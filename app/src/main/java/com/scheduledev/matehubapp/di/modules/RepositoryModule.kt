package com.scheduledev.matehubapp.di.modules

import com.sheduledev.data.auth.login.AuthRepositoryImpl
import com.sheduledev.data.auth.registration.RegRepositoryImpl
import com.sheduledev.domain.repo.AuthRepository
import com.sheduledev.domain.repo.RegRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    @Binds
    fun bindRegRepository(repository: RegRepositoryImpl): RegRepository

}