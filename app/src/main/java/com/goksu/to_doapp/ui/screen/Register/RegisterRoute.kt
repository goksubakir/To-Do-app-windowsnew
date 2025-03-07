package com.goksu.to_doapp.ui.screen.Register


import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.goksu.to_doapp.ui.screen.register.RegisterViewModel

@Composable
fun RegisterRoute(
    viewModel: RegisterViewModel = viewModel(),
    onRegisterSuccess: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    RegisterScreen(
        uiState = uiState,
        onUsernameChange = viewModel::onUsernameChange,
        onFullNameChange = viewModel::onFullNameChange,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        onRegisterClicked = viewModel::register,
        onRegisterSuccess = onRegisterSuccess
    )
}
