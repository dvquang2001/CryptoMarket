package jetpack.tutorial.cryptoapp.presentation.main.market

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.ui.theme.ColorGreen
import jetpack.tutorial.cryptoapp.ui.theme.ColorRed
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun MarketHeader(
    totalCoinsPercent: Double,
    modifier: Modifier = Modifier
) {
    val titleText = if (totalCoinsPercent < 0)
        stringResource(id = R.string.market_is_down)
    else
        stringResource(id = R.string.market_is_up)

    val color = if(totalCoinsPercent < 0) ColorRed else ColorGreen
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row {
            Text(
                text = titleText,
                style = LargeTextBold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "$totalCoinsPercent%",
                style = LargeTextBold,
                fontSize = 20.sp,
                color = color
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(id = R.string.in_the_past_24_hours),
            style = SmallTextRegular
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMarketHeader() {
    CryptoAppTheme {
        MarketHeader(11.7)
    }
}