package com.sheduledev.data.auth.registration.network

import com.sheduledev.data.auth.common.AuthRequest
import com.sheduledev.data.auth.common.AuthResponse
import javax.inject.Inject

class RegRemoteDataSource @Inject constructor(private val regApi: RegApi) {

    suspend fun performReg(login: String, password: String): AuthResponse {
        return regApi.performReg(
            body = AuthRequest(
                login = login,
                password = password
            )
        )
    }
}