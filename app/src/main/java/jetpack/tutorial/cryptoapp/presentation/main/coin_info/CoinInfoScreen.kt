package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextSemiBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.LightSurface
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@RequiresApi(Build.VERSION_CODES.O)
@Destination
@Composable
fun CoinInfoScreen(
    id: String,
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: CoinInfoViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = CoinInfoViewModel.ViewState())
    if(state.cryptoInfo != null) {
        val cryptoInfo = state.cryptoInfo!!
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(
                    color = LightSurface
                )
                .padding(16.dp)
        ) {
            CoinInfoHeader(
                crypto = cryptoInfo,
                onBackClicked = {
                    navigator.popBackStack()
                }
            )
            Spacer(modifier = Modifier.height(60.dp))
            CoinPricesChart(
                infos = state.dataIntraInfo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row (
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = ColorWhite,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = cryptoInfo.imageLarge,
                    contentDescription = "coin",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = cryptoInfo.name,
                        style = LargeTextBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "00.00 ${cryptoInfo.symbol.uppercase()}",
                        style = SmallTextRegular
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "$00.00",
                        style = LargeTextBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "00.00%",
                        style = SmallTextRegular
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = ColorWhite,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = "Transactions",
                    style = LargeTextSemiBold
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = ColorWhite,
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp
                        )
                    )
                    .padding(16.dp)
            ) {
                Box (
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = LightPrimary,
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .clickable {
                            //todo: onBuyClicked
                        }
                ) {
                    Text(
                        text = "BUY",
                        style = LargeTextSemiBold, 
                        color = ColorWhite,
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box (
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            color = LightPrimary,
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .clickable {
                            //todo: onSellClicked
                        }
                ) {
                    Text(
                        text = "SELL",
                        style = LargeTextSemiBold,
                        color = ColorWhite,
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = state.error.toString())
        }
    }
}