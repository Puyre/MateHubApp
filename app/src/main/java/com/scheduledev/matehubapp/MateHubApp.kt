package com.scheduledev.matehubapp

import com.scheduledev.matehubapp.di.ApplicationComponent
import com.scheduledev.matehubapp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MateHubApp : DaggerApplication() {

    lateinit var appComponent: ApplicationComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        appComponent = DaggerApplicationComponent
            .factory()
            .create(this)

        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
    }
}
