package com.sheduledev.data.auth.login

import com.sheduledev.data.auth.common.local.TokenLocalDataSource
import com.sheduledev.data.auth.login.network.AuthRemoteDataSource
import com.sheduledev.domain.model.TokenPair
import com.sheduledev.domain.model.exceptions.ConnectionExc
import com.sheduledev.domain.model.exceptions.InvalidCredentialsExc
import com.sheduledev.domain.repo.AuthRepository
import retrofit2.HttpException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remote: AuthRemoteDataSource,
    private val local: TokenLocalDataSource
) :
    AuthRepository {

    companion object {
        const val INVALID_CREDENTIAL = 400
    }

    override suspend fun performAuth(login: String, password: String): TokenPair {
        try {
            val authResponse = remote.performAuth(login = login, password = password)
            val tokenPair = TokenPair(
                accessToken = authResponse.accessToken,
                refreshToken = authResponse.refreshToken
            )
            local.setTokens(tokenPair)
            return tokenPair
        } catch (httpExc: HttpException) {
            if (httpExc.code() == INVALID_CREDENTIAL) {
                throw InvalidCredentialsExc
            } else {
                throw ConnectionExc
            }
        } catch (exc: Exception) {
            throw ConnectionExc
        }

    }
}