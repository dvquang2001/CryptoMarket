package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.cryptoapp.features.crypto.domain.usecase.get_crypto_info.GetCryptoInfoUseCase
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import javax.inject.Inject

class CoinInfoViewModel @Inject constructor(
    private val getCryptoInfoUseCase: GetCryptoInfoUseCase
) : BaseViewModel<CoinInfoViewModel.ViewState, CoinInfoViewModel.ViewEvent, CoinInfoViewModel.ViewEffect>(
    ViewState()
){

    private fun getCoinInfo() {

    }

    override fun onEvent(event: ViewEvent) {
        TODO("Not yet implemented")
    }

    data class ViewState(
        val cryptoInfo: CryptoInfoModel? = null
    ): BaseViewState

    sealed class ViewEvent: BaseViewEvent {
        data class SellCoin(val id: String): ViewEvent()
        data class BuyCoin(val id: String): ViewEvent()
    }

    class ViewEffect: BaseViewEffect
}