package com.goksu.to_doapp.screen.profil

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject



@HiltViewModel
class ProfileViewModel @Inject constructor(): ViewModel(){

    private val _uiState=MutableStateFlow(ProfileUiState())
    val uiState get()=_uiState.asStateFlow()
}