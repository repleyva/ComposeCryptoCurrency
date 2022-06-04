package repleyva.dev.cryptocurrency.presentation.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import repleyva.dev.cryptocurrency.presentation.ui.coin_detail.CoinDetailScreen
import repleyva.dev.cryptocurrency.presentation.ui.coin_list.CoinListScreen

@Composable
fun Navigations() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen { coin ->
                navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
            }
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }
    }
}