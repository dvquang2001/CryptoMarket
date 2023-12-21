package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@RequiresApi(Build.VERSION_CODES.O)
@Destination
@Composable
fun CoinInfoScreen(
    id: String,
    modifier: Modifier = Modifier,
    viewModel: CoinInfoViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = CoinInfoViewModel.ViewState())
    if(state.cryptoInfo != null) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            CoinInfoHeader(crypto = state.cryptoInfo!!)
            Spacer(modifier = Modifier.height(60.dp))
            CoinPricesChart(
                infos = state.dataIntraInfo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
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