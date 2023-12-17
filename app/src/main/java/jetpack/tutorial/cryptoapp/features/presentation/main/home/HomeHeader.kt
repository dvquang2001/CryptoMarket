package jetpack.tutorial.cryptoapp.features.presentation.main.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "Welcome",
            style = SmallTextRegular,
            color = ColorWhite
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Make your first Investment today",
            fontStyle = FontStyle(R.font.open_sans_bold),
            color = ColorWhite,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

    }
}