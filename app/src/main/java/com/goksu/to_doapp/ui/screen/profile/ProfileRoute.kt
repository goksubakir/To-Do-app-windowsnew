package com.goksu.to_doapp.ui.screen.profile

import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ProfileRoute(
    viewModel: ProfileViewModel,
    onBackClick: () -> Unit,
    completedTasks: Int,
    pendingTasks: Int,
    totalTasks: Int
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val updatedUiState = uiState.copy(
        completedTasks = completedTasks,
        pendingTasks = pendingTasks,
        totalTasks = totalTasks
    )

    ProfileScreen(
        onBackClick = onBackClick,
        uiState = updatedUiState,
        onUsernameChange = { viewModel.updateUsername(it) }
    )
}
