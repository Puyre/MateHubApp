package com.sheduledev.data.auth.network

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("/signup")
    suspend fun performAuth(@Body body: AuthRequest): AuthResponse
}