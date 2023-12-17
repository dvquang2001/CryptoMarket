package jetpack.tutorial.cryptoapp.features.presentation.main.home

import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.cryptoapp.features.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.features.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.features.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.features.presentation.base.BaseViewState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : BaseViewModel<HomeViewModel.ViewState, HomeViewModel.ViewEvent, HomeViewModel.ViewEffect>(
    ViewState()
){

    override fun onEvent(event: ViewEvent) {
        TODO("Not yet implemented")
    }

    class ViewState(): BaseViewState

    class ViewEvent: BaseViewEvent

    class ViewEffect: BaseViewEffect
}