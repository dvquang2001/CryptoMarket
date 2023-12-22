package jetpack.tutorial.cryptoapp.presentation.main.rewards.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import jetpack.tutorial.cryptoapp.ui.theme.MediumTextBold
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun ListTile(
    title: String,
    result: String,
    textResultColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = SmallTextRegular
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = result,
            color = textResultColor,
            style = MediumTextBold
        )
    }
}