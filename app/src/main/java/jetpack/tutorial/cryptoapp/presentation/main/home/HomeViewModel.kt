package jetpack.tutorial.cryptoapp.presentation.main.home

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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCryptoListingUseCase: GetCryptoListingUseCase
) : BaseViewModel<HomeViewModel.ViewState, HomeViewModel.ViewEvent, HomeViewModel.ViewEffect>(
    ViewState()
){

    private var getListCoinsJob: Job? = null

    init {
        getListCoins(fetchFromRemote = true)
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
                getListCoins()
            }
            is ViewEvent.OnSearchQueryChange -> {
                setState(
                    currentState.copy(
                        searchQuery = event.query
                    )
                )
                getListCoinsJob?.cancel()
                getListCoinsJob = coroutineScope.launch {
                    delay(500)
                    getListCoins()
                }
            }
        }
    }

    data class ViewState(
        val listCoins: List<CryptoListingModel> = emptyList(),
        val isLoading: Boolean = false,
        val isRefreshing: Boolean = false,
        val searchQuery: String = ""
    ): BaseViewState

    sealed class ViewEvent: BaseViewEvent {
        data object Refresh: ViewEvent()
        data class OnSearchQueryChange(val query: String): ViewEvent()
    }

    class ViewEffect: BaseViewEffect

    override fun onCleared() {
        super.onCleared()
        getListCoinsJob?.cancel()
    }
}