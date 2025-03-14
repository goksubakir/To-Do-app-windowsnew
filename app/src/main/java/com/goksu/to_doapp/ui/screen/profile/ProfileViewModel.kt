package com.goksu.to_doapp.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState(location = "Istanbul, Turkey"))
    val uiState: StateFlow<ProfileUiState> = _uiState

    init {
        val username = savedStateHandle.get<String>("username") ?: "User"
        val completedTasks = savedStateHandle.get<Int>("completedTasks") ?: 0
        val pendingTasks = savedStateHandle.get<Int>("pendingTasks") ?: 0
        val totalTasks = savedStateHandle.get<Int>("totalTasks") ?: 0

        _uiState.value = ProfileUiState(
            username = username,
            completedTasks = completedTasks,
            pendingTasks = pendingTasks,
            totalTasks = totalTasks,
            location = "Istanbul, Turkey"
        )
    }

    fun updateUsername(newUsername: String) {
        _uiState.value = _uiState.value.copy(username = newUsername)
    }
}
