package jetpack.tutorial.cryptoapp.presentation.main.market

import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoListingModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_listing.CryptoListingParam
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_listing.GetCryptoListingUseCase
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    private val getCryptoListingUseCase: GetCryptoListingUseCase
) : BaseViewModel<MarketViewModel.ViewState, MarketViewModel.ViewEvent, MarketViewModel.ViewEffect>(ViewState()){

    private var getListCoinsJob: Job? = null

    init {
        getListCoins()
    }

    private fun getListCoins(fetchFromRemote: Boolean = false) {
        getListCoinsJob = getCryptoListingUseCase.execute(
            param = CryptoListingParam(
                fetchFromRemote = fetchFromRemote,
                query = currentState.searchQuery.lowercase()
            )
        ).onEach {
            when (it) {
                is ResultModel.Success -> {
                    setState(
                        currentState.copy(
                            listCoins = it.result.map { crypto ->
                                crypto.copy(priceChangePercentage24h =
                                Math.round(crypto.priceChangePercentage24h * 100.0) / 100.0)
                            },
                            listFilteredCoins = it.result.map { crypto ->
                                crypto.copy(priceChangePercentage24h =
                                Math.round(crypto.priceChangePercentage24h * 100.0) / 100.0)
                            },
                        )
                    )
                }

                is ResultModel.Error -> {

                }
            }
        }.launchIn(coroutineScope)
    }

    private fun getListFilter(selectedTab: TabMarket): List<CryptoListingModel> {
        val filterList = currentState.listCoins.filter {
            when(selectedTab) {
                TabMarket.ALL -> {
                    it.currentPrice != 0.0
                }
                TabMarket.GAINER -> {
                    it.currentPrice > 0
                }
                TabMarket.LOSER -> {
                    it.currentPrice < 0
                }
            }
        }
        return filterList
    }

    override fun onEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.OnQuerySearch -> {

            }

            is ViewEvent.Refresh -> {
                getListCoins(fetchFromRemote = true)
                setState(
                    currentState.copy(
                        listFilteredCoins = getListFilter(currentState.currentTab)
                    )
                )
            }

            is ViewEvent.ChangeTab -> {
                setState(
                    currentState.copy(
                        currentTab = event.selectedTab,
                        listFilteredCoins = getListFilter(event.selectedTab)
                    )
                )
            }
        }
    }

    data class ViewState(
        val listCoins: List<CryptoListingModel> = emptyList(),
        val listFilteredCoins: List<CryptoListingModel> = emptyList(),
        val listTab: List<String> = listOf(TabMarket.ALL, TabMarket.GAINER, TabMarket.LOSER).map { it.name },
        val currentTab: TabMarket = TabMarket.ALL,
        val searchQuery: String = "",
        val isRefreshing: Boolean = false
    ): BaseViewState

    sealed class ViewEvent : BaseViewEvent {
        data class OnQuerySearch(val query: String): ViewEvent()
        data object Refresh: ViewEvent()

        data class ChangeTab(val selectedTab: TabMarket): ViewEvent()
    }

    class ViewEffect: BaseViewEffect

    override fun onCleared() {
        super.onCleared()
        getListCoinsJob?.cancel()
    }
}