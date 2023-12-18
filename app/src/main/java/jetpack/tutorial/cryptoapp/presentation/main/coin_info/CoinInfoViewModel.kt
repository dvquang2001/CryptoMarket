package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import javax.inject.Inject

class CoinInfoViewModel @Inject constructor(

) : BaseViewModel<CoinInfoViewModel.ViewState, CoinInfoViewModel.ViewEvent, CoinInfoViewModel.ViewEffect>(
    ViewState()
){

    override fun onEvent(event: ViewEvent) {
        TODO("Not yet implemented")
    }

    class ViewState(): BaseViewState

    class ViewEvent: BaseViewEvent

    class ViewEffect: BaseViewEffect
}