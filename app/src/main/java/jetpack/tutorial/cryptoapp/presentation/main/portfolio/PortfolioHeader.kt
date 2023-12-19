package jetpack.tutorial.cryptoapp.presentation.main.portfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextSemiBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun PortfolioHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(
                color = LightPrimary,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(
                vertical = 24.dp,
                horizontal = 20.dp
            )
    ) {
        Text(
            text = "PortFolio",
            style = LargeTextBold,
            fontSize = 20.sp,
            color = ColorWhite
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Holding value",
            style = SmallTextRegular,
            color = ColorWhite
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$2,598.75",
            style = LargeTextBold,
            fontSize = 24.sp,
            color = ColorWhite
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row {
            Column {
                Text(
                    text = "Invested value",
                    style = SmallTextRegular,
                    color = ColorWhite
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$1,618.75",
                    style = LargeTextSemiBold,
                    color = ColorWhite,
                    fontSize = 18.sp
                )
            }
            Divider(
                color = ColorWhite,
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .fillMaxHeight()
                    .width(1.dp)

            )
            Column {
                Text(
                    text = "Available INR",
                    style = SmallTextRegular,
                    color = ColorWhite
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$1589",
                    style = LargeTextSemiBold,
                    color = ColorWhite,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPortfolioHeader() {
    CryptoAppTheme {
        PortfolioHeader()
    }
}