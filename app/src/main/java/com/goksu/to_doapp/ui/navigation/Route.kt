package com.goksu.to_doapp.ui.navigation

sealed class Route(val route: String) {
    object Splash : Route("splash")
    object Home : Route("home")
    object Profile : Route("profile")
    object RandomText : Route("random_text") // Rastgele metin ekranı rotasını buraya ekledim ana sayfada gozukmesi icin
    object Login : Route("login")
}
