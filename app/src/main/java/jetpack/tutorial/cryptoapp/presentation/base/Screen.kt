package jetpack.tutorial.cryptoapp.presentation.base

import androidx.annotation.DrawableRes
import jetpack.tutorial.cryptoapp.R

sealed class Screen(val route: String, @DrawableRes val iconRes: Int, val label: String) {
    data object Home : Screen("home", R.drawable.ic_home, "Home")
    data object Portfolio : Screen("portfolio", R.drawable.ic_portfolio, "Portfolio")
    data object Rewards: Screen("rewards", R.drawable.ic_rewards, "Rewards")
    data object Market : Screen("market", R.drawable.ic_market, "Market")
    data object Profile : Screen("profile", R.drawable.ic_profile, "Profile")
}

val itemsScreen = listOf(
    Screen.Home,
    Screen.Portfolio,
    Screen.Rewards,
    Screen.Market,
    Screen.Profile,
)