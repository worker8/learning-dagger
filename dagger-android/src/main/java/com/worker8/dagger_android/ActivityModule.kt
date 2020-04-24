package com.worker8.dagger_android

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @PerActivityScope
    @ContributesAndroidInjector
    abstract fun contributeDemoActivity(): DemoActivity

}

