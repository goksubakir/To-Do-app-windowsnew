package com.goksu.to_doapp.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.goksu.to_doapp.ui.screen.splash.SplashViewModel

@Composable
fun SplashRoute(
    viewModel: SplashViewModel,
    onSplashCompleted: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()


    SplashScreen(
        onSplashComplete = {
            onSplashCompleted()
        }
    )

}
