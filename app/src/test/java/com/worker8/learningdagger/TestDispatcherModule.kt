package com.worker8.learningdagger

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class TestDispatcherModule {
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
}