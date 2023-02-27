package com.scheduledev.matehubapp.di.modules

import com.sheduledev.domain.repo.AuthRepository
import com.sheduledev.domain.usecases.AuthUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    @Singleton
    fun provideAuthUseCase(authRep: AuthRepository) = AuthUseCase(authRep)
}