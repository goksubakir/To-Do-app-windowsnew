package com.goksu.to_doapp.ui.screen.profile

data class ProfileUiState(
    val isLoading: Boolean = false,
    val name: String = "  ",
    val completedTasks: Int = 0,
    val pendingTasks: Int = 0,
    val totalTasks: Int = 0
)
