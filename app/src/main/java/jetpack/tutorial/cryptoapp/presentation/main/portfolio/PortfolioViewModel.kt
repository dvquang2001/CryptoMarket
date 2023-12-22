package jetpack.tutorial.cryptoapp.presentation.main.portfolio

import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.crypto.domain.model.CryptoListingModel
import jetpack.tutorial.crypto.domain.usecase.get_crypto_listing.CryptoListingParam
import jetpack.tutorial.crypto.domain.usecase.get_crypto_listing.GetCryptoListingUseCase
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import jetpack.tutorial.cryptoapp.presentation.extentions.toCryptoListingUI
import jetpack.tutorial.libcore.networking.utils.ResultModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val getCryptoListingUseCase: GetCryptoListingUseCase
) : BaseViewModel<PortfolioViewModel.ViewState, PortfolioViewModel.ViewEvent, PortfolioViewModel.ViewEffect>(
    ViewState()
){

    private var getListCoinsJob: Job? = null

    init {
        getListCoins(fetchFromRemote = false)
    }

    private fun getListCoins(fetchFromRemote: Boolean = false) {
        getListCoinsJob = getCryptoListingUseCase.execute(
            param = CryptoListingParam(
                fetchFromRemote = fetchFromRemote,
                query = ""
            )
        ).onEach {
            when (it) {
                is ResultModel.Success -> {
                    setState(
                        currentState.copy(
                            listCoins = it.result.toCryptoListingUI()
                        )
                    )
                }

                is ResultModel.Error -> {

                }
            }
        }.launchIn(coroutineScope)
    }

    override fun onEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.Refresh -> {
                getListCoins(fetchFromRemote = true)
            }
        }
    }

    data class ViewState(
        val listCoins: List<CryptoListingModel> = emptyList(),
        val isLoading: Boolean = false,
        val isRefreshing: Boolean = false,
    ): BaseViewState

    sealed class ViewEvent: BaseViewEvent {
        data object Refresh: ViewEvent()
    }

    class ViewEffect: BaseViewEffect

    override fun onCleared() {
        super.onCleared()
        getListCoinsJob?.cancel()
    }
}