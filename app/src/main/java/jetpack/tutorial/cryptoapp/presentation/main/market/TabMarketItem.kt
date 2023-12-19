package jetpack.tutorial.cryptoapp.presentation.main.market

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.presentation.extentions.upperFirstCharacterAndLowerRemainingCharacter
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.MediumTextMedium

@Composable
fun TabMarketItem(
    tabName: String,
    modifier: Modifier = Modifier,
    isSelectedTab: Boolean = false
) {
    Column(
        modifier = modifier
            .padding(end = 24.dp)
    ) {
        Text(
            text = tabName.upperFirstCharacterAndLowerRemainingCharacter(),
            style = MediumTextMedium,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(2.dp))
        Divider(
            modifier = Modifier
                .background(color = if(isSelectedTab) LightPrimary else Color.Transparent)
                .height(4.dp)
        )
    }
}