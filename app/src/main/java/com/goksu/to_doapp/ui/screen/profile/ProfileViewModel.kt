package com.goksu.to_doapp.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    init {
        // Mock data - replace with actual data fetching
        viewModelScope.launch {
            _uiState.value = ProfileUiState(
                name = "Ad Soyad", // TODO: Burada kullanicidan veri alinacak
                completedTasks = 15,
                pendingTasks = 5,// TODO: Burada kullanicidan veri alinacak
                        totalTasks = 20
            )
        }
    }
}
