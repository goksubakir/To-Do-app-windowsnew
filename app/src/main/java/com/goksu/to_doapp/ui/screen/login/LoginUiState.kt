package com.goksu.to_doapp.ui.screen.login

data class LoginUiState(
    var username: String = "",
    var password: String = "",
    val isLoggedIn: Boolean = false
)
