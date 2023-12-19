package jetpack.tutorial.cryptoapp.presentation.main.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import jetpack.tutorial.cryptoapp.destinations.CoinInfoScreenDestination
import jetpack.tutorial.cryptoapp.presentation.main.common.CaButton
import jetpack.tutorial.cryptoapp.presentation.main.common.CoinItem
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary

@Composable
fun PortfolioScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: PortfolioViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = PortfolioViewModel.ViewState())
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                vertical = 12.dp,
                horizontal = 16.dp
            )
    ) {
        PortfolioHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            CaButton(
                text = "Deposit INR",
                onClick = { /*TODO*/ },
                textColor = ColorWhite,
                bgColor = LightPrimary
            )
            CaButton(
                text = "Withdraw INR",
                onClick = { /*TODO*/ }
            )
        }
        Text(
            text = "Your coins",
            style = LargeTextBold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(vertical = 20.dp)
        )
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                viewModel.onEvent(
                    PortfolioViewModel.ViewEvent.Refresh
                )
            }) {
            LazyColumn {
                items(state.listCoins) { crypto ->
                    CoinItem(crypto) { id ->
                        navigator.navigate(CoinInfoScreenDestination(id))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPortfolioScreen() {
    CryptoAppTheme {
        //PortfolioScreen()
    }
}