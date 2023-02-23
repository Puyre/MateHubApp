package com.scheduledev.matehubapp.di.modules

import com.sheduledev.data.auth.AuthRepositoryImpl
import com.sheduledev.domain.repo.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface RepositoryModule {

    @Binds
    fun bindAuthRepository(repository: AuthRepositoryImpl) : AuthRepository

}