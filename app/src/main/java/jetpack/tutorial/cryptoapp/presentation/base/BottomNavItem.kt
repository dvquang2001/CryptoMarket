package jetpack.tutorial.cryptoapp.presentation.base

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home: BottomNavItem("home", Icons.Default.Home, "Home")
    data object Portfolio: BottomNavItem("portfolio", Icons.Default.Info, "Portfolio")
    data object Market: BottomNavItem("market", Icons.Default.List, "Market")
    data object Profile: BottomNavItem("profile", Icons.Default.AccountCircle, "Profile")
}