package com.scheduledev.auth.login

sealed class LoginScreenState {
    object Initial : LoginScreenState()
    object Loading : LoginScreenState()
    data class Error(val exc: Exception) : LoginScreenState()
    object Success : LoginScreenState()
}
