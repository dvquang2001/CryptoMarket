package jetpack.tutorial.cryptoapp.presentation.main.rewards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.destinations.ReferAndEarnScreenDestination
import jetpack.tutorial.cryptoapp.presentation.main.rewards.components.CouponsCategory
import jetpack.tutorial.cryptoapp.presentation.main.rewards.components.ReferralCategory
import jetpack.tutorial.cryptoapp.presentation.main.rewards.components.RewardsCard
import jetpack.tutorial.cryptoapp.ui.theme.ColorOrange
import jetpack.tutorial.cryptoapp.ui.theme.ColorPurple
import jetpack.tutorial.cryptoapp.ui.theme.LightBackground

@Composable
fun RewardsScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: RewardsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = RewardsViewModel.ViewState())
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = LightBackground
            )
            .padding(16.dp)
    ) {
        item {
            CouponsCategory(state = state)
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            ReferralCategory(
                totalReferral = state.totalReferral,
                totalQualifiedReferral = state.totalQualifiedReferral
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            RewardsCard(
                title = stringResource(id = R.string.refer_and_earn),
                content = stringResource(id = R.string.refer_you_friend_and_win_crypto_coins),
                textButton = stringResource(id = R.string.refer_now),
                imageRes = R.drawable.ic_refer_and_earn,
                backgroundColor = ColorOrange,
                onButtonClicked = {
                    //todo: onReferNow
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            RewardsCard(
                title = stringResource(id = R.string.rewards),
                content = stringResource(id = R.string.like_share_get_coupons),
                textButton = stringResource(id = R.string.share_now),
                imageRes = R.drawable.ic_rewards_share,
                backgroundColor = ColorPurple,
                onButtonClicked = {
                    navigator.navigate(ReferAndEarnScreenDestination())
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}