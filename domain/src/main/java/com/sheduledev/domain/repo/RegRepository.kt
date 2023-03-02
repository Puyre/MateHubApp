package com.sheduledev.domain.repo

import com.sheduledev.domain.model.TokenPair

interface RegRepository {

    suspend fun performRegistration(login: String, password: String): TokenPair
}