package jetpack.tutorial.cryptoapp.presentation.main.rewards

import dagger.hilt.android.lifecycle.HiltViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEffect
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewEvent
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewModel
import jetpack.tutorial.cryptoapp.presentation.base.BaseViewState
import javax.inject.Inject

@HiltViewModel
class RewardsViewModel @Inject constructor(

) : BaseViewModel<RewardsViewModel.ViewState, RewardsViewModel.ViewEvent, RewardsViewModel.ViewEffect>(
    ViewState()
){

    override fun onEvent(event: ViewEvent) {
        TODO("Not yet implemented")
    }

    data class ViewState(
        val couponsWonAmount: Int = 0,
        val tokensWonFromSpinAmount: Int = 0,
        val remainingCouponsAmount: Int = 0,
        val totalReferral: Int = 0,
        val totalQualifiedReferral: Int = 0,
    ): BaseViewState

    sealed class ViewEvent : BaseViewEvent

    class ViewEffect: BaseViewEffect
}