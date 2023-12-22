package jetpack.tutorial.cryptoapp.presentation.main.refer_and_earn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.presentation.main.rewards.components.ReferralCategory
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextSemiBold
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun ReferAndEarnScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item{
            ReferralCategory()
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp, horizontal = 12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_refer_lock),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(id = R.string.refer_and_earn_free_crypto_currency),
                    style = LargeTextSemiBold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.refer_and_earn_desc),
                    style = SmallTextRegular,
                )
                Spacer(modifier = Modifier.height(24.dp))
                //todo: layout copy link
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.share_now).uppercase(),
                        color = ColorWhite,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}