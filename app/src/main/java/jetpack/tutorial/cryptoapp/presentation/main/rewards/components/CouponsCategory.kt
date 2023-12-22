package jetpack.tutorial.cryptoapp.presentation.main.rewards.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.presentation.main.rewards.RewardsViewModel
import jetpack.tutorial.cryptoapp.ui.theme.ColorBlack
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary

@Composable
fun CouponsCategory(
    state: RewardsViewModel.ViewState,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = ColorWhite,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.coupons),
            style = LargeTextBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        ListTile(
            title = stringResource(id = R.string.no_of_coupons_won),
            result = state.couponsWonAmount.toString(),
            textResultColor = ColorBlack
        )
        ListTile(
            title = stringResource(id = R.string.tokens_won_from_spin_so_far),
            result = state.tokensWonFromSpinAmount.toString(),
            textResultColor = LightPrimary
        )
        ListTile(
            title = stringResource(id = R.string.remaining_coupons_to_spin),
            result = state.remainingCouponsAmount.toString(),
            textResultColor = LightPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCouponsCategory() {
    CryptoAppTheme {
        CouponsCategory(RewardsViewModel.ViewState())
    }
}