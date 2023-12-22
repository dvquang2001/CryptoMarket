package jetpack.tutorial.cryptoapp.presentation.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jetpack.tutorial.authentication.domain.model.UserDataModel
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.presentation.main.common.CaButton
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LargeTextSemiBold
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary
import jetpack.tutorial.cryptoapp.ui.theme.SmallTextRegular

@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    currentUser: UserDataModel? = null
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = LightPrimary,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(vertical = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.default_avatar),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Agilan Senthil",
            style = LargeTextSemiBold,
            color = ColorWhite,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "agilansenthilkumar@gmail.com",
            style = SmallTextRegular,
            color = ColorWhite
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "+84 972533708",
            style = SmallTextRegular,
            color = ColorWhite
        )
        if(currentUser == null) {
            Spacer(modifier = Modifier.height(12.dp))
            CaButton(
                text = "Login",
                onClick = {
                    //todo: navigate to screen login
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreenHeader() {
    CryptoAppTheme {
        ProfileHeader()
    }
}