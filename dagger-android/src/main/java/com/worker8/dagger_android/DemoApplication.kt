package com.worker8.dagger_android

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class DemoApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerDemoComponent
            .builder()
            .application(this)
            .build()
    }
}