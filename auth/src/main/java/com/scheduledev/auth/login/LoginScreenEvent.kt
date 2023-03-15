package com.scheduledev.auth.login

sealed class LoginScreenEvent {
    data class LoginEvent(
        val email: String,
        val password: String
    ) : LoginScreenEvent()
}
