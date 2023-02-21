package com.scheduledev.matehubapp.di.modules

import android.content.Context
import com.scheduledev.matehubapp.MateHubApp
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideContext(app: MateHubApp): Context = app.applicationContext
}