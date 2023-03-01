package com.sheduledev.data.auth.registration.network

import com.sheduledev.data.auth.common.AuthRequest
import com.sheduledev.data.auth.common.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RegApi {

    @POST("signup")
    suspend fun performReg(@Body body: AuthRequest): AuthResponse
}