package com.worker8.learningdagger.multibinding.di

import android.content.Context
import com.worker8.learningdagger.multibinding.JackRabbitActivity
import com.worker8.learningdagger.multibinding.RabbitActivity
import com.worker8.learningdagger.multibinding_viewmodel.di.DispatcherModule
import com.worker8.learningdagger.multibinding_viewmodel.di.RabbitRepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RabbitRepositoryModule::class, ViewModule::class, WolfModule::class, DispatcherModule::class])
interface ViewModelComponent {
    fun inject(activity: RabbitActivity)
    fun inject(activity: JackRabbitActivity)

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun bindContext(context: Context): Builder

        abstract fun build(): ViewModelComponent
    }
}