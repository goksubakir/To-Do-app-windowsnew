package com.goksu.to_doapp.ui.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable


fun SplashRoute(
    viewModel: SplashViewModel,
    onSplashComplete: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SplashScreen(
        uiState = uiState,
        onSplashComplete = onSplashComplete
    )
}

