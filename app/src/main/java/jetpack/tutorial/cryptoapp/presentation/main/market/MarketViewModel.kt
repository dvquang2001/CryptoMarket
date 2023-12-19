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
import jetpack.tutorial.cryptoapp.presentation.extentions.roundBy2Numbers
import jetpack.tutorial.cryptoapp.presentation.extentions.toCryptoListingUI
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
                    val listCoins = it.result.toCryptoListingUI()
                    val totalPercent = listCoins
                        .filter { coin -> coin.priceChangePercentage24h > 0 }
                        .sumOf { coin -> coin.priceChangePercentage24h }
                    setState(
                        currentState.copy(
                            listCoins = listCoins,
                            listFilteredCoins = listCoins,
                            totalCoinsPercent = totalPercent.roundBy2Numbers()
                        )
                    )
                }

                is ResultModel.Error -> {

                }
            }
        }.launchIn(coroutineScope)
    }

    private fun getListFilter(selectedTab: TabMarket): List<CryptoListingModel> {
        val filterList = when(selectedTab) {
            TabMarket.ALL -> currentState.listCoins
            TabMarket.GAINER -> {
                currentState.listCoins.filter { it.priceChangePercentage24h > 0.0 }
            }
            TabMarket.LOSER -> {
                currentState.listCoins.filter { it.priceChangePercentage24h < 0.0 }
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
        val listTab: List<TabMarket> = listOf(TabMarket.ALL, TabMarket.GAINER, TabMarket.LOSER),
        val currentTab: TabMarket = TabMarket.ALL,
        val searchQuery: String = "",
        val isRefreshing: Boolean = false,
        val totalCoinsPercent: Double = 0.0,
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