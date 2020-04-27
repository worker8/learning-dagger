package com.worker8.learningdagger

import com.worker8.learningdagger.multibinding_viewmodel.rabbitMVVM.RabbitRepositoryInterface
import dagger.Module
import dagger.Provides

@Module
class TestRabbitRepositoryModule {
    @Provides
    fun provideRabbitRepository(): RabbitRepositoryInterface {
        return object : RabbitRepositoryInterface {
            override suspend fun fetchNames(): List<String> {
                return listOf("test name 1", "test name 2")
            }
        }
    }
}