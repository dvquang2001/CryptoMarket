package jetpack.tutorial.cryptoapp.presentation.main.market

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import jetpack.tutorial.cryptoapp.destinations.CoinInfoScreenDestination
import jetpack.tutorial.cryptoapp.presentation.main.common.CoinItem
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold

@Composable
fun MarketScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: MarketViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = MarketViewModel.ViewState())
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        MarketHeader(onSearchClick = { /*TODO*/ })
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 16.dp)
        ) {
            Text(
                text = "Coins",
                style = LargeTextBold,
                fontSize = 20.sp
            )
        }
        LazyRow {
            items(state.listTab) { tabName ->
                val isSelectedTab = tabName == state.currentTab.name
                TabMarketItem(tabName = tabName, isSelectedTab = isSelectedTab)
            }
        }
        Divider(Modifier.width(1.dp))
        Spacer(modifier = Modifier.height(16.dp))
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {

            }) {
            LazyColumn {
                items(state.listFilteredCoins) { crypto ->
                    CoinItem(crypto) { id ->
                        navigator.navigate(CoinInfoScreenDestination(id))
                    }
                }
            }
        }
    }
}