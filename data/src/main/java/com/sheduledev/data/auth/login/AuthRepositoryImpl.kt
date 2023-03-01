package com.sheduledev.data.auth.login

import com.sheduledev.data.auth.common.local.TokenLocalDataSource
import com.sheduledev.data.auth.login.network.AuthRemoteDataSource
import com.sheduledev.domain.model.TokenPair
import com.sheduledev.domain.repo.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remote: AuthRemoteDataSource,
    private val local: TokenLocalDataSource
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