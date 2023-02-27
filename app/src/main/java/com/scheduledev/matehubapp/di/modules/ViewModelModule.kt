package com.scheduledev.matehubapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.scheduledev.auth.login.AuthViewModel
import com.scheduledev.auth.registration.RegistrationViewModel
import com.scheduledev.matehubapp.di.util.ViewModelFactory
import com.scheduledev.matehubapp.di.util.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun provideAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    abstract fun provideRegistrationViewModel(viewModel: RegistrationViewModel): ViewModel
}