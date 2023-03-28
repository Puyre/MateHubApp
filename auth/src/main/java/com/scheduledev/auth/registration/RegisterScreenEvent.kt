package com.scheduledev.auth.registration

sealed class RegisterScreenEvent {
    data class RegisterEvent(
        val email: String,
        val password: String
    ) : RegisterScreenEvent()
}
