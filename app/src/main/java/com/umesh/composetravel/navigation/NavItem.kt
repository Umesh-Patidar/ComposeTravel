package com.umesh.composetravel.navigation

import com.umesh.composetravel.R


sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    object Home :
        BottomNavItem(route = Screen.Main.Home.route, icon = R.drawable.ic_home, "Home")

    object History :
        BottomNavItem(route = Screen.Main.History.route, icon = R.drawable.ic_clock, "History")

    object Favorite :
        BottomNavItem(route = Screen.Main.Favorite.route, icon = R.drawable.ic_heart, "Favorite")

    object Profile :
        BottomNavItem(route = Screen.Main.Profile.route, icon = R.drawable.ic_user, "Profile")
}

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash")

    object Main : Screen(route = "main") {
        object Home : Screen(route = "home")
        object History : Screen(route = "history")
        object Favorite : Screen(route = "favorite")
        object Profile : Screen(route = "profile")
    }

    object Detail : Screen(route = "detail/{itemId}") {
        fun createRoute(itemId: Int) = "detail/$itemId"
    }
}

