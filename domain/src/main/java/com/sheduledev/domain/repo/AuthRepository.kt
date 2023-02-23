package com.sheduledev.domain.repo

import com.sheduledev.domain.model.TokenPair

interface AuthRepository {

    suspend fun performAuth(login: String, password: String): TokenPair
}