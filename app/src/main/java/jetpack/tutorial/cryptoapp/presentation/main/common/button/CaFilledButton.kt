package jetpack.tutorial.cryptoapp.presentation.main.common.button

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary

@Composable
fun CaFilledButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = ColorWhite,
    backgroundColor: Color = LightPrimary
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier) {

    }
}