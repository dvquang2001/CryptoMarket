package jetpack.tutorial.cryptoapp.presentation.main.refer_and_earn

import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import javax.inject.Inject

@HiltViewModel
class ReferAndEarnViewModel @Inject constructor(

) : BaseViewModel<ReferAndEarnViewModel.ViewState, ReferAndEarnViewModel.ViewEvent, ReferAndEarnViewModel.ViewEffect>(
    ViewState()
){

    override fun onEvent(event: ViewEvent) {
        TODO("Not yet implemented")
    }

    class ViewState : BaseViewState

    class ViewEvent: BaseViewEvent

    class ViewEffect: BaseViewEffect
}