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
import jetpack.tutorial.cryptoapp.ui.theme.ColorBlack
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary

@Composable
fun ReferralCategory(
    modifier: Modifier = Modifier,
    totalReferral: Int = 0,
    totalQualifiedReferral: Int = 0,
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
            text = stringResource(id = R.string.referral),
            style = LargeTextBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        ListTile(
            title = stringResource(id = R.string.total_no_of_referral),
            result = totalReferral.toString(),
            textResultColor = ColorBlack
        )
        ListTile(
            title = stringResource(id = R.string.total_no_of_qualified_referral),
            result = totalQualifiedReferral.toString(),
            textResultColor = LightPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewReferralCategory() {
    CryptoAppTheme {
        ReferralCategory()
    }
}