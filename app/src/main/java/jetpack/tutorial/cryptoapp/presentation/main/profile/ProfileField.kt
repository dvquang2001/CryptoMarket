package jetpack.tutorial.cryptoapp.presentation.main.profile

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextMedium

@Composable
fun ProfileField(
    @DrawableRes
    iconRes: Int,
    text: String,
    modifier: Modifier = Modifier,
    @DrawableRes
    rightIconRes: Int = R.drawable.ic_arrow_right
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = 24.dp)
       ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = text
            )
           Spacer(modifier = Modifier.width(16.dp))
           Text(
               text = text,
               style = LargeTextMedium,
               fontSize = 18.sp
           )
           Spacer(modifier = Modifier.weight(1f))
           Image(painter = painterResource(id = rightIconRes), contentDescription = null)
       }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )
    }
}