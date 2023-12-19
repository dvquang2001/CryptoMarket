package jetpack.tutorial.cryptoapp.presentation.main.common

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary

@Composable
fun CaButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = LightPrimary,
    bgColor: Color = ColorWhite
) {
    OutlinedButton(
        border = null,
        onClick = onClick,
        modifier = modifier
            .background(
                color = bgColor,
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Text(text = text, color = textColor)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCaButton() {
    CryptoAppTheme {
        CaButton(text = "Invest Today", onClick = { })
    }
}