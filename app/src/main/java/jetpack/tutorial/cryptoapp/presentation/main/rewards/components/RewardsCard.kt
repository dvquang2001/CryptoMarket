package jetpack.tutorial.cryptoapp.presentation.main.rewards.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextMedium
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun RewardsCard(
    title: String,
    content: String,
    textButton: String,
    @DrawableRes
    imageRes: Int,
    onButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = LightPrimary,
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = SmallTextRegular,
                color = ColorWhite
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                style = LargeTextBold,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                color = ColorWhite
            )
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = modifier
                    .background(
                        color = ColorWhite,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(
                        vertical = 8.dp,
                        horizontal = 12.dp
                    )
                    .clickable {
                        onButtonClicked()
                    }
            ) {
                Text(
                    text = textButton,
                    color = backgroundColor,
                    style = SmallTextMedium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null
        )
    }
}