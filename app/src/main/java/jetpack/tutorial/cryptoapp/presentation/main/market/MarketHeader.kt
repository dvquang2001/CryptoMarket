package jetpack.tutorial.cryptoapp.presentation.main.market

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.ui.theme.ColorRed
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun MarketHeader(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val titleText = "Market is down"
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Row {
                Text(
                    text = titleText,
                    style = LargeTextBold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "-11.17%",
                    style = LargeTextBold,
                    fontSize = 20.sp,
                    color = ColorRed
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "In the past 24 hours",
                style = SmallTextRegular
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = onSearchClick) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMarketHeader() {
    CryptoAppTheme {
        MarketHeader(onSearchClick = { })
    }
}