package com.worker8.learningdagger.multibinding_viewmodel.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
class DispatcherModule {
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}