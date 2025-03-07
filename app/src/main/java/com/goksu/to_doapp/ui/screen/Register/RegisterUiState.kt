package com.goksu.to_doapp.ui.screen.Register


data class RegisterUiState(
    val username: String = "",
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isRegistered: Boolean = false,
    val errorMessage: String? = null
)
