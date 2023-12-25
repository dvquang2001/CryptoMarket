package jetpack.tutorial.cryptoapp.presentation.main.refer_and_earn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.presentation.main.rewards.components.ReferralCategory
import jetpack.tutorial.cryptoapp.presentation.utils.Constants.DEFAULT_REFERRAL_LINK
import jetpack.tutorial.cryptoapp.ui.theme.ColorBlack
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextSemiBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.MediumTextBold
import jetpack.tutorial.cryptoapp.ui.theme.MediumTextRegular
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextMedium
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Destination
@Composable
fun ReferAndEarnScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: ReferAndEarnViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            navigator.popBackStack()
                        }
                    )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(id = R.string.refer_and_earn),
                    style = LargeTextSemiBold
                )
            }
        }
        item{
            Spacer(modifier = Modifier.height(20.dp))
            ReferralCategory()
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ColorWhite,
                        shape = RoundedCornerShape(
                            size = 8.dp
                        )
                    )
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
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                ReferralLink(link = DEFAULT_REFERRAL_LINK)
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(
                            color = LightPrimary,
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .clickable {
                            //todo: Share action
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.share_now).uppercase(),
                        color = ColorWhite,
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = stringResource(id = R.string.terms_and_conditions_applied),
                    color = LightPrimary,
                    style = SmallTextMedium
                )
            }
        }
    }
}

@Composable
private fun ReferralLink(
    link: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.your_referral_link),
            style = MediumTextBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.Transparent,
                )
                .border(
                    width = 1.dp,
                    ColorBlack,
                    RoundedCornerShape(4.dp)
                )
                .padding(8.dp)
        ) {
            Text(
                text = link,
                style = MediumTextRegular,
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .background(
                        color = LightPrimary,
                        shape = RoundedCornerShape(size = 4.dp)
                    )
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.copy_code),
                    color = ColorWhite
                )
            }
        }
    }
}

