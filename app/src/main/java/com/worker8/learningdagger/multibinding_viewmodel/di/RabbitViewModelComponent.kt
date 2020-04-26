package com.worker8.learningdagger.multibinding.di

import android.content.Context
import com.worker8.learningdagger.di.ApplicationScope
import com.worker8.learningdagger.multibinding.RabbitActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RabbitModule::class, WolfModule::class])
@ApplicationScope
interface RabbitViewModelComponent {
    fun inject(activity: RabbitActivity)

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun bindContext(context: Context): Builder

        abstract fun build(): RabbitViewModelComponent
    }
}