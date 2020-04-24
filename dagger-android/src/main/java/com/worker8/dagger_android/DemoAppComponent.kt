package com.worker8.dagger_android

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class
    ]
)
interface DemoComponent : AndroidInjector<DemoApplication> {
    fun inject(activity: DemoActivity)

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun application(application: DemoApplication): Builder

        abstract fun build(): DemoComponent
    }
}