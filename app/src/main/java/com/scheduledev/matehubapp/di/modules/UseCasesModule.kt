package com.scheduledev.matehubapp.di.modules

import com.sheduledev.domain.repo.AuthRepository
import com.sheduledev.domain.repo.RegRepository
import com.sheduledev.domain.usecases.AuthUseCase
import com.sheduledev.domain.usecases.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun provideAuthUseCase(authRep: AuthRepository) = AuthUseCase(authRep)

    @Provides
    @Singleton
    fun provideRegisterUseCase(regRep: RegRepository) = RegisterUseCase(regRep)
}