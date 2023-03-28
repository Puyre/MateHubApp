package com.sheduledev.domain.usecases

import com.sheduledev.domain.model.TokenPair
import com.sheduledev.domain.repo.RegRepository

class RegisterUseCase(private val regRep: RegRepository) {

    suspend operator fun invoke(login: String, password: String): TokenPair {
        return regRep.performRegistration(login = login, password = password)
    }
}