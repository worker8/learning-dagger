package com.worker8.learningdagger

import com.worker8.learningdagger.multibinding.di.ViewModule
import com.worker8.learningdagger.multibinding.di.WolfModule
import com.worker8.learningdagger.multibinding_viewmodel.di.DispatcherModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestRabbitRepositoryModule::class, ViewModule::class, WolfModule::class, TestDispatcherModule::class])
interface TestViewModelComponent {

    fun inject(test: RabbitViewModelTest)

    @Component.Builder
    abstract class Builder {

        abstract fun build(): TestViewModelComponent
    }
}