package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CoinInfoScreen(
    id: String,
    modifier: Modifier = Modifier,
    viewModel: CoinInfoViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState(initial = CoinInfoViewModel.ViewState())
    Column {
        Text(text = state.cryptoInfo?.id ?: state.error.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = state.dataIntraInfo.size.toString())
    }
}

@Composable
fun CoinInfoHeader(
    modifier: Modifier = Modifier
) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
    }
}