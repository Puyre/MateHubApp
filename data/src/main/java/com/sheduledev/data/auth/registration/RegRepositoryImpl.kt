package com.sheduledev.data.auth.registration

import com.sheduledev.data.auth.common.local.TokenLocalDataSource
import com.sheduledev.data.auth.registration.network.RegRemoteDataSource
import com.sheduledev.domain.model.TokenPair
import com.sheduledev.domain.repo.RegRepository
import javax.inject.Inject

class RegRepositoryImpl @Inject constructor(
    private val local: TokenLocalDataSource,
    private val remote: RegRemoteDataSource,
) : RegRepository {


    override suspend fun performRegistration(login: String, password: String): TokenPair {
        val regResponse = remote.performReg(login = login, password = password)
        val tokenPair = TokenPair(
            accessToken = regResponse.accessToken,
            refreshToken = regResponse.refreshToken
        )
        local.setTokens(tokenPair)
        return tokenPair
    }
}