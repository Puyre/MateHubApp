package com.scheduledev.auth.login

sealed class LoginScreenState {
    object Initial : LoginScreenState()
    object Loading : LoginScreenState()
    data class Error(val message: String) : LoginScreenState()
    object Success : LoginScreenState()
}
