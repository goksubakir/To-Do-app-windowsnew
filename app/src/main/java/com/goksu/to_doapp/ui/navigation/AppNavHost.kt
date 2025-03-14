package com.goksu.to_doapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.goksu.to_doapp.ui.screen.home.HomeScreen
import com.goksu.to_doapp.ui.screen.login.LoginRoute
import com.goksu.to_doapp.ui.screen.login.LoginViewModel
import com.goksu.to_doapp.ui.screen.profile.ProfileRoute
import com.goksu.to_doapp.ui.screen.profile.ProfileViewModel
import com.goksu.to_doapp.ui.screen.registerr.RegisterRoute
import com.goksu.to_doapp.ui.screen.registerr.RegisterViewModel
import com.goksu.to_doapp.ui.screen.splash.SplashRoute
import com.goksu.to_doapp.ui.screen.splash.SplashViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Splash.route
    ) {
        // **Splash Ekranı**
        composable(Route.Splash.route) {
            val viewModel: SplashViewModel = hiltViewModel()
            SplashRoute(
                onSplashComplete = {
                    navController.navigate(Route.Login.route) {
                        popUpTo(Route.Splash.route) { inclusive = true }
                    }
                },
                viewModel = viewModel
            )
        }

        // **Ana Sayfa (HomeScreen)**
        composable(Route.Home.route) {
            HomeScreen(
                onProfileClick = { completedTasks, pendingTasks, totalTasks ->
                    navController.navigate("profile/$completedTasks/$pendingTasks/$totalTasks")
                },
                onRandomTextClick = {
                    navController.navigate(Route.RandomText.route)
                }
            )
        }

        // **Profil Ekranı (ProfileScreen)**
        composable(
            route = "profile/{completedTasks}/{pendingTasks}/{totalTasks}",
            arguments = listOf(
                navArgument("completedTasks") { type = NavType.IntType },
                navArgument("pendingTasks") { type = NavType.IntType },
                navArgument("totalTasks") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val completedTasks = backStackEntry.arguments?.getInt("completedTasks") ?: 0
            val pendingTasks = backStackEntry.arguments?.getInt("pendingTasks") ?: 0
            val totalTasks = backStackEntry.arguments?.getInt("totalTasks") ?: 0

            val viewModel: ProfileViewModel = hiltViewModel()

            ProfileRoute(
                onBackClick = {
                    navController.popBackStack()
                },
                onLogout = {
                    navController.navigate(Route.Login.route) {
                        popUpTo(Route.Home.route) { inclusive = true }
                    }
                },
                viewModel = viewModel,
                completedTasks = completedTasks,
                pendingTasks = pendingTasks,
                totalTasks = totalTasks
            )
        }

        // **Login Ekranı**
        composable(Route.Login.route) {
            val viewModel: LoginViewModel = hiltViewModel()
            LoginRoute(
                viewModel = viewModel,
                onLoginSuccess = {
                    navController.navigate(Route.Home.route) {
                        popUpTo(Route.Login.route) { inclusive = true }
                    }
                },
                onRegisterClicked = {
                    navController.navigate(Route.Register.route)
                }
            )
        }

        // **Register (Kayıt) Ekranı**
        composable(Route.Register.route) {
            val viewModel: RegisterViewModel = hiltViewModel()
            RegisterRoute(
                viewModel = viewModel,
                onRegisterSuccess = {
                    navController.navigate(Route.Login.route) {
                        popUpTo(Route.Register.route) { inclusive = true }
                    }
                }
            )
        }
    }
}