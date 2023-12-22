package jetpack.tutorial.cryptoapp.presentation.main.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import jetpack.tutorial.cryptoapp.R
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme

@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            item {
                ProfileField(
                    iconRes = R.drawable.ic_history,
                    text = stringResource(id = R.string.history)
                )
            }
            item {
                ProfileField(
                    iconRes = R.drawable.ic_bank_details,
                    text = stringResource(id = R.string.bank_details)
                )
            }
            item {
                ProfileField(
                    iconRes = R.drawable.ic_notifications,
                    text = stringResource(id = R.string.notifications)
                )
            }
            item {
                ProfileField(
                    iconRes = R.drawable.ic_security,
                    text = stringResource(id = R.string.security)
                )
            }
            item {
                ProfileField(
                    iconRes = R.drawable.ic_help_and_support,
                    text = stringResource(id = R.string.help_and_support)
                )
            }
            item {
                ProfileField(
                    iconRes = R.drawable.ic_terms_and_conditions,
                    text = stringResource(id = R.string.terms_and_conditions)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    CryptoAppTheme {
        //ProfileScreen()
    }
}