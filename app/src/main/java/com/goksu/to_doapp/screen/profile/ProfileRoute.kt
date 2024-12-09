package com.goksu.to_doapp.screen.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable

fun ProfileRoute(
    viewModel: ProfileViewModel,
    onBackClick: () -> Unit
){

    val uiState by viewModel.uistate.collectAsStateWithLifecycle()

    ProfileScreen(
        onBackClick=onBackClick
        uiState= uiState
    )
}