package jetpack.tutorial.cryptoapp.presentation.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.presentation.main.common.CaButton
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
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
            text = stringResource(id = R.string.welcome),
            style = SmallTextRegular,
            color = ColorWhite
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.home_title),
            fontStyle = FontStyle(R.font.open_sans_bold),
            color = ColorWhite,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        CaButton(text = stringResource(id = R.string.invest_today), onClick = { /*TODO*/ })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeHeader() {
    CryptoAppTheme {
        HomeHeader()
    }
}