package com.sheduledev.data.auth.login.network

import com.sheduledev.data.auth.common.AuthRequest
import com.sheduledev.data.auth.common.AuthResponse
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(val authApi: AuthApi) {

    suspend fun performAuth(login: String, password: String): AuthResponse {
        return authApi.performAuth(
            body = AuthRequest(
                login = login,
                password = password
            )
        )
    }
}