package com.umesh.composetravel

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.umesh.composetravel.navigation.BottomNavigationBar
import com.umesh.composetravel.navigation.Screen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainScreen() {
    SharedTransitionLayout {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { BottomNavigationBar(navController = navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Main.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Main.Home.route) {
                    HomeScreen(
                        navController = navController,
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedContentScope = this@composable
                    )
                }
                composable(Screen.Main.Favorite.route) { FavoriteScreen(navController = navController) }
                composable(Screen.Main.History.route) { HistoryScreen(navController = navController) }
                composable(Screen.Main.Profile.route) { ProfileScreen(navController = navController) }

                composable(
                    Screen.Detail.route,
                    arguments = listOf(navArgument("itemId") { type = NavType.IntType }),
                ) { backStackEntry ->
                    val itemId = backStackEntry.arguments?.getInt("itemId", 0) ?: 0
                    DestinationDetailScreen(
                        navController = navController,
                        itemId = itemId,
                        sharedTransitionScope = this@SharedTransitionLayout,
                        animatedContentScope = this@composable
                    )
                }
            }
        }
    }
}
