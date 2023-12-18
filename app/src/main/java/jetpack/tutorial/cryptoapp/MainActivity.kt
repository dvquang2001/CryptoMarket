package jetpack.tutorial.cryptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import jetpack.tutorial.cryptoapp.presentation.base.Screen
import jetpack.tutorial.cryptoapp.presentation.main.home.HomeScreen
import jetpack.tutorial.cryptoapp.presentation.main.market.MarketScreen
import jetpack.tutorial.cryptoapp.presentation.main.portfolio.PortfolioScreen
import jetpack.tutorial.cryptoapp.presentation.main.profile.ProfileScreen
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val items = listOf(
        Screen.Home,
        Screen.Portfolio,
        Screen.Market,
        Screen.Profile,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent(items = items)
                }
            }
        }
    }
}

@Composable
fun AppContent(items: List<Screen>) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.heightIn(80.dp),
                backgroundColor = ColorWhite,
                elevation = 3.dp,
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon, contentDescription = null,
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                        },
                        label = { Text(text = screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        selectedContentColor = ColorWhite,
                        alwaysShowLabel = true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Portfolio.route) {
                PortfolioScreen()
            }
            composable(Screen.Market.route) {
                MarketScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}