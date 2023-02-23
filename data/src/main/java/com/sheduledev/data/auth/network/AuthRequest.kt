package com.sheduledev.data.auth.network

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    val login: String,
    val password: String,
)
