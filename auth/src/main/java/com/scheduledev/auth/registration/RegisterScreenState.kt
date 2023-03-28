package com.scheduledev.auth.registration

sealed class RegisterScreenState {

    object Initial : RegisterScreenState()
    object Loading : RegisterScreenState()
    data class Error(val exc: Exception) : RegisterScreenState()
    object Success : RegisterScreenState()
}
