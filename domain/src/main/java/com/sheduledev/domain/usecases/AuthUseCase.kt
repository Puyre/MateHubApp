package com.sheduledev.domain.usecases

import com.sheduledev.domain.model.TokenPair
import com.sheduledev.domain.repo.AuthRepository

class AuthUseCase(private val authRep: AuthRepository) {

    suspend operator fun invoke(login: String, password: String): TokenPair {
        return authRep.performAuth(login = login, password = password)
    }
}
