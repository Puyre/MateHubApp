package com.scheduledev.matehubapp

//import com.scheduledev.matehubapp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MateHubApp : DaggerApplication() {

    val appComponent = DaggerApplicationComponent.create()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerApplicationComponent
            .factory()
            .create(this)
    }

    override fun onCreate() {
        super.onCreate()
    }
}
