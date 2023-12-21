package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.cryptoapp.core.networking.utils.ResultModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.PairData
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.convertToListPairData
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_info.CryptoInfoParam
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_info.GetCryptoInfoUseCase
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_intra_info.CryptoIntraInfoParam
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_intra_info.GetCryptoIntraInfoUseCase
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getCryptoInfoUseCase: GetCryptoInfoUseCase,
    private val getCryptoIntraInfoUseCase: GetCryptoIntraInfoUseCase
) : BaseViewModel<CoinInfoViewModel.ViewState, CoinInfoViewModel.ViewEvent, CoinInfoViewModel.ViewEffect>(
    ViewState()
){

    private var getCoinPricesJob: Job? = null

    init {
        getCoinInfo()
        getCoinPrices()
    }

    private fun getCoinInfo() {
        coroutineScope.launch {
            val id = savedStateHandle.get<String>("id") ?: return@launch
            val coinInfoFlow = getCryptoInfoUseCase.execute(CryptoInfoParam(id))
                .collect {
                when(it) {
                    is ResultModel.Success -> {
                        setState(
                            currentState.copy(
                                cryptoInfo = it.result
                            )
                        )
                    }

                    is ResultModel.Error -> {
                        setState(
                            currentState.copy(
                                error = it.t.message
                            )
                        )
                    }
                }
            }
        }
    }

    private fun getCoinPrices() {
        val id = savedStateHandle.get<String>("id") ?: return
        getCoinPricesJob?.cancel()
        getCoinPricesJob = getCryptoIntraInfoUseCase.execute(CryptoIntraInfoParam(id))
            .onEach {
                when(it) {
                    is ResultModel.Success -> {
                        setState(
                            currentState.copy(
                                dataIntraInfo = it.result.convertToListPairData().takeLast(10)
                            )
                        )
                    }

                    is ResultModel.Error -> {
                        setState(
                            currentState.copy(
                                error = it.t.toString()
                            )
                        )
                    }
                }
            }.launchIn(coroutineScope)
    }

    override fun onEvent(event: ViewEvent) {
        TODO("Not yet implemented")
    }

    data class ViewState(
        val cryptoInfo: CryptoInfoModel? = null,
        val error: String? = null,
        val dataIntraInfo: List<PairData> = emptyList()
    ): BaseViewState

    sealed class ViewEvent: BaseViewEvent {
        data class SellCoin(val id: String): ViewEvent()
        data class BuyCoin(val id: String): ViewEvent()
    }

    class ViewEffect: BaseViewEffect

    override fun onCleared() {
        super.onCleared()
        getCoinPricesJob?.cancel()
    }
}