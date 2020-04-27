package com.worker8.learningdagger.componentBuilder.di

import android.content.Context
import com.worker8.learningdagger.componentBuilder.ComponentBuilderActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CBRepositoryModule::class])
interface CBComponent {
    fun inject(activity: ComponentBuilderActivity)

    @Component.Builder
    abstract class Builder {
        //        @BindsInstances
        abstract fun cBRepositoryModule(module: CBRepositoryModule): Builder

        @BindsInstance
        abstract fun bindContext(context: Context): Builder

        abstract fun build(): CBComponent
    }
}