package com.goksu.to_doapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.goksu.to_doapp.screen.home.HomeScreen
import com.goksu.to_doapp.screen.profile.ProfileRoute
import com.goksu.to_doapp.screen.profile.ProfileViewModel
import com.goksu.to_doapp.screen.splash.SplashRoute
import com.goksu.to_doapp.screen.splash.SplashViewModel


// Composable bir fonksiyon tanımlıyoruz. Bu, uygulama için bir navigasyon sistemi sağlar.
// `AppNavHost` adındaki bu fonksiyon, bir `NavHostController` alır ve onu kullanarak ekranlar arasında geçiş yapar.
@Composable
fun AppNavHost(navController: NavHostController) {

    // Jetpack Compose'un NavHost bileşenini kullanıyoruz.
    // `navController` navigasyonu yönetmek için kullanılır.
    // `startDestination` başlangıç ekranını belirtir (bu durumda Splash ekranı).
    NavHost(
        navController = navController, // Navigasyonun kontrol edilmesini sağlar.
        startDestination = Route.Splash.route // Uygulamanın ilk açıldığında gösterilecek ekran.
    ) {
        // Splash ekranını tanımlıyoruz. Bu, `Route.Splash.route` rotasıyla ilişkilidir.
        composable(Route.Splash.route) {
            val viewModel = hiltViewModel<SplashViewModel>()
            SplashRoute(
                onSplashComplete = {
                    navController.navigate(Route.Home.route) {
                        popUpTo(Route.Splash.route) { inclusive = true }
                    }
                },
                viewModel = viewModel
            )
        }

        // Home ekranını tanımlıyoruz. Bu, `Route.Home.route` rotasıyla ilişkilidir.
        composable(Route.Home.route) {
            // HomeScreen bileşenini çağırıyoruz.
            // Kullanıcı profil ekranına geçmek istediğinde `onProfileClick` callback'i çağrılır.
            HomeScreen(
                onProfileClick = {
                    // Profil ekranına yönlendirme yapıyoruz.
                    navController.navigate(Route.Profile.route)
                }
            )
        }

        // Profil ekranını tanımlıyoruz. Bu, `Route.Profile.route` rotasıyla ilişkilidir.
        composable(Route.Profile.route) {
            // ProfileScreen bileşenini çağırıyoruz.
            // Kullanıcı geri dönmek istediğinde `onBackClick` callback'i çağrılır.

            val viewModel = hiltViewModel<ProfileViewModel>()
            ProfileRoute(
                onBackClick = {
                    navController.popBackStack()
                },
                viewModel = viewModel

            )
        }
    }
}