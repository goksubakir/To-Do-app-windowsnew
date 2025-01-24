package com.goksu.to_doapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.goksu.to_doapp.screen.home.HomeScreen
import com.goksu.to_doapp.screen.randomtext.RandomTextScreen
import com.goksu.to_doapp.screen.profile.ProfileRoute
import com.goksu.to_doapp.screen.profile.ProfileViewModel
import com.goksu.to_doapp.screen.splash.SplashRoute
import com.goksu.to_doapp.screen.splash.SplashViewModel
import com.goksu.to_doapp.screen.randomtext.RandomTextScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Splash.route
    ) {
        // Splash ekranı
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

        // Home ekranı
        composable(Route.Home.route) {
            HomeScreen(
                onProfileClick = {
                    navController.navigate(Route.Profile.route)
                },
                onRandomTextClick = {
                    navController.navigate(Route.RandomText.route)
                }
            )
        }

        // Profil ekranı
        composable(Route.Profile.route) {
            val viewModel = hiltViewModel<ProfileViewModel>()
            ProfileRoute(
                onBackClick = {
                    navController.popBackStack()
                },
                viewModel = viewModel
            )
        }

        // Rastgele metin ekranı
        composable(Route.RandomText.route) {
            RandomTextScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
