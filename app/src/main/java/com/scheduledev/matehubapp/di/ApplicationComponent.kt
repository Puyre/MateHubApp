package com.scheduledev.matehubapp.di

import com.scheduledev.matehubapp.MateHubApp
import com.scheduledev.matehubapp.di.modules.*
import com.sheduledev.data.di.modules.LocalModule
import com.sheduledev.data.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        UseCasesModule::class,
        NetworkModule::class,
        LocalModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MateHubApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: MateHubApp): ApplicationComponent
    }
}