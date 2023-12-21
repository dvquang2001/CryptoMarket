package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.features.crypto.domain.model.CryptoInfoModel
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold

@Composable
fun CoinInfoHeader(
    onBackClicked: () -> Unit,
    crypto: CryptoInfoModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {
                        onBackClicked()
                    }
            )
            Spacer(modifier = Modifier.width(8.dp))
            AsyncImage(
                model = crypto.imageSmall,
                contentDescription = "coin",
                modifier = Modifier
                    .size(40.dp)
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = crypto.name,
                style = LargeTextBold
            )
            Text(text = " (${crypto.symbol.uppercase()})")
            Spacer(modifier = Modifier.width(12.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "Favorite"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$${crypto.totalVolume}",
            style = LargeTextBold,
            fontSize = 24.sp
        )
    }
}