package com.goksu.to_doapp.ui.navigation

// `Route` adlı bir `sealed class` tanımlıyoruz.
// `sealed class`, Kotlin'de sınıflar hiyerarşisini sınırlandırmak için kullanılır.
// Bu, yalnızca bu sınıf içinde tanımlanan alt sınıfların kullanılabileceği anlamına gelir.
// Bu sınıf, uygulamanın navigasyon rotalarını temsil eder.
sealed class Route(val route: String) {

    // Her bir alt sınıf, bir ekranın rotasını temsil eder.
    // `object` ile singleton yapılar oluşturuyoruz, çünkü her rota tek ve sabit bir yapıya sahiptir.

    object Splash : Route("splash") // Splash ekranının rotası, "splash" olarak tanımlanmıştır.
    object Home : Route("home")     // Home ekranının rotası, "home" olarak tanımlanmıştır.
    object Profile : Route("profile") // Profile ekranının rotası, "profile" olarak tanımlanmıştır.
}
