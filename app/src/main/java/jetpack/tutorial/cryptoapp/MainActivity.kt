package jetpack.tutorial.cryptoapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint
import jetpack.tutorial.cryptoapp.presentation.base.Screen
import jetpack.tutorial.cryptoapp.presentation.base.itemsScreen
import jetpack.tutorial.cryptoapp.presentation.main.home.HomeScreen
import jetpack.tutorial.cryptoapp.presentation.main.market.MarketScreen
import jetpack.tutorial.cryptoapp.presentation.main.portfolio.PortfolioScreen
import jetpack.tutorial.cryptoapp.presentation.main.profile.ProfileScreen
import jetpack.tutorial.cryptoapp.presentation.main.rewards.RewardsScreen
import jetpack.tutorial.cryptoapp.presentation.utils.Constants
import jetpack.tutorial.cryptoapp.presentation.utils.Constants.AD_BANNER_UNIT_ID_TEST
import jetpack.tutorial.cryptoapp.ui.theme.ColorWhite
import jetpack.tutorial.cryptoapp.ui.theme.CryptoAppTheme
import jetpack.tutorial.cryptoapp.ui.theme.LightPrimary

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this)
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder().setTestDeviceIds(listOf("ABCDEF123")).build()
        )
        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                            modifier = Modifier
                                .weight(1f)
                        )
                        AdmobBanner(modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}

@Destination(start = true)
@Composable
fun AppContent(
    navigator: DestinationsNavigator
) {
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
                itemsScreen.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter =  painterResource(id = screen.iconRes), contentDescription = null,
                                modifier = Modifier.padding(bottom = 6.dp)
                            )
                        },
                        label = { Text(text = screen.label, fontSize = 12.sp) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        selectedContentColor = Color.Blue,
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
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navigator)
            }
            composable(Screen.Portfolio.route) {
                PortfolioScreen(navigator)
            }
            composable(Screen.Rewards.route) {
                RewardsScreen(navigator)
            }
            composable(Screen.Market.route) {
                MarketScreen(navigator)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navigator)
            }
        }
    }
}

@Composable
fun AdmobBanner(
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                adUnitId = AD_BANNER_UNIT_ID_TEST
                loadAd(AdRequest.Builder().build())
            }
        },
        modifier = modifier
            .fillMaxWidth()
    )
}