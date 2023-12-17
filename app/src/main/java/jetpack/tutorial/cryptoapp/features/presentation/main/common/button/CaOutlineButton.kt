package jetpack.tutorial.cryptoapp.features.presentation.main.common.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextMedium

@Composable
fun CaOutlineButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = LightPrimary
) {
    OutlinedButton(
        contentPadding = PaddingValues(16.dp),
        border = null,
        onClick = onClick,
        modifier = modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        Text(
            text = "Invest Today",
            style = SmallTextMedium,
            color = color
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCaOutlineButton() {
    CryptoAppTheme {
        CaOutlineButton(onClick = {})
    }
}

