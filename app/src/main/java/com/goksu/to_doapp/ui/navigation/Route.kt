package com.goksu.to_doapp.ui.navigation

sealed class Route(val route: String) {
    object Splash : Route("splash")
    object Home : Route("home")
    object Profile : Route("profile")
    object Login : Route("login")
    object Register : Route("register")
    object RandomText : Route("randomText")
}


