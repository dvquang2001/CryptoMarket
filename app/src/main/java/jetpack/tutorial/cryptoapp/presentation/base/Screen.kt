package jetpack.tutorial.cryptoapp.presentation.base

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, val label: String) {
    data object Home : Screen("home", Icons.Default.Home, "Home")
    data object Portfolio : Screen("portfolio", Icons.Default.Info, "Portfolio")
    data object Market : Screen("market", Icons.Default.List, "Market")
    data object Profile : Screen("profile", Icons.Default.AccountCircle, "Profile")
}

val itemsScreen = listOf(
    Screen.Home,
    Screen.Portfolio,
    Screen.Market,
    Screen.Profile,
)