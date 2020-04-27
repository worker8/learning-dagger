package com.worker8.learningdagger.multibinding_viewmodel.di

import android.content.Context
import com.worker8.learningdagger.multibinding_viewmodel.rabbitMVVM.RabbitRepository
import com.worker8.learningdagger.multibinding_viewmodel.rabbitMVVM.RabbitRepositoryInterface
import dagger.Module
import dagger.Provides

@Module
class RabbitRepositoryModule {
    @Provides
    fun provideRabbitRepository(context: Context): RabbitRepositoryInterface {
        return RabbitRepository(context)
    }
}