package jetpack.tutorial.cryptoapp.presentation.main.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import jetpack.tutorial.cryptoapp.ui.theme.ColorGreen
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextSemiBold
import jetpack.tutorial.cryptoapp.ui.theme.LightOnSurfaceVariant
import jetpack.tutorial.cryptoapp.ui.theme.MediumTextRegular
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextBold

@Composable
fun CoinItem(
    //todo: pass the param of the item here
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(
                color = ColorWhite,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(16.dp)
    ) {
        AsyncImage(
            model = "https://assets.coingecko.com/coins/images/1/small/bitcoin.png?1696501400",
            contentDescription = "coin",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = "Bitcoin",
                style = LargeTextBold,
            )
            Text(
                text = "BTC",
                style = MediumTextRegular,
                color = LightOnSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column {
            Text(
                text = "$2,509.75",
                style = LargeTextSemiBold
            )
            Text(
                text = "+9.77%",
                style = SmallTextBold,
                color = ColorGreen
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCoinItem() {
    CryptoAppTheme {
        CoinItem()
    }
}