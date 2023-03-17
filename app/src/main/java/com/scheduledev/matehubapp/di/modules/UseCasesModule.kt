package com.scheduledev.matehubapp.di.modules

import com.sheduledev.domain.repo.AuthRepository
import com.sheduledev.domain.usecases.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun provideAuthUseCase(authRep: AuthRepository) = AuthUseCase(authRep)
}