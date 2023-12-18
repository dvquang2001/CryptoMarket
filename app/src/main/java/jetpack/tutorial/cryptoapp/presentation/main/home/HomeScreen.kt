package jetpack.tutorial.cryptoapp.presentation.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
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
import jetpack.tutorial.cryptoapp.presentation.main.common.CoinItem
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextSemiBold
import jetpack.tutorial.cryptoapp.ui.theme.LightBackground

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = HomeViewModel.ViewState())
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = LightBackground
            )
            .padding(16.dp)
    ) {
        HomeHeader()
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Trending Coins",
            style = LargeTextSemiBold,
            fontSize = 20.sp)
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(
                    HomeViewModel.ViewEvent.OnSearchQueryChange(it)
                )
            },
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            placeholder = {
                Text(text = "Search...")
            },
            maxLines = 1,
            singleLine = true
        )
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                viewModel.onEvent(
                    HomeViewModel.ViewEvent.Refresh
                )
            }
        ) {
            LazyColumn {
                items(state.listCoins) { crypto ->
                    CoinItem(crypto) { id ->
                        // navigate to screen crypto info
                    }
                }
            }
        }
    }
    
    
}

