package com.scheduledev.matehubapp.di

import com.scheduledev.matehubapp.MateHubApp
import com.scheduledev.matehubapp.di.modules.ActivityModule
import com.scheduledev.matehubapp.di.modules.ApplicationModule
import com.scheduledev.matehubapp.di.modules.UseCasesModule
import com.scheduledev.matehubapp.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        UseCasesModule::class,
    ]
)
interface ApplicationComponent : AndroidInjector<MateHubApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: MateHubApp): ApplicationComponent
    }
}