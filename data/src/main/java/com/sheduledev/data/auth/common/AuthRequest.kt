package com.sheduledev.data.auth.common

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    val login: String,
    val password: String,
)
