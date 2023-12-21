package jetpack.tutorial.cryptoapp.presentation.main.profile

import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(

): BaseViewModel<ProfileViewModel.ViewState, ProfileViewModel.ViewEvent, ProfileViewModel.ViewEffect>(
    ViewState()
){

    override fun onEvent(event: ViewEvent) {
        TODO("Not yet implemented")
    }

    class ViewState: BaseViewState

    class ViewEvent: BaseViewEvent

    class ViewEffect: BaseViewEffect
}