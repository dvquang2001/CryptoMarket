package jetpack.tutorial.cryptoapp.presentation.main.coin_info

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun CoinInfoScreen(
    modifier: Modifier = Modifier
) {
    Text(text = "Info")
}

@Composable
fun CoinInfoHeader(
    modifier: Modifier = Modifier
) {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
    }
}