package com.scheduledev.matehubapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.scheduledev.matehubapp.di.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}