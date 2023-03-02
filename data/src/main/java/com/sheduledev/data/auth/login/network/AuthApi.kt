package com.sheduledev.data.auth.login.network

import com.sheduledev.data.auth.common.AuthRequest
import com.sheduledev.data.auth.common.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/login")
    suspend fun performAuth(@Body body: AuthRequest): AuthResponse
}