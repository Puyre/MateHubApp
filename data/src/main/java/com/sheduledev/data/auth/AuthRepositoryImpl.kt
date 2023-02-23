package com.sheduledev.data.auth

import com.sheduledev.data.auth.local.AuthLocalDataSource
import com.sheduledev.data.auth.network.AuthRemoteDataSource
import com.sheduledev.domain.model.TokenPair
import com.sheduledev.domain.repo.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remote: AuthRemoteDataSource,
    private val local: AuthLocalDataSource
) :
    AuthRepository {

    override suspend fun performAuth(login: String, password: String): TokenPair {
        val authResponse = remote.performAuth(login = login, password = password)
        val tokenPair = TokenPair(
            accessToken = authResponse.accessToken,
            refreshToken = authResponse.refreshToken
        )
        local.setTokens(tokenPair)
        return tokenPair
    }
}