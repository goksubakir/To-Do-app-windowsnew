package com.goksu.to_doapp.ui.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SplashRoute(
    viewModel: SplashViewModel,
    onSplashCompleted: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (!uiState.isLoading) {
        onSplashCompleted() // Splash ekranı bittiğinde bir işlem tetiklenir
    } else {
        SplashScreen()
    }
}
