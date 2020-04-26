package com.worker8.learningdagger.multibinding.di

import androidx.lifecycle.ViewModel
import com.worker8.learningdagger.multibinding.RabbitViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RabbitModule {
    @Binds
    @IntoMap
    @RabbitViewModelKey(RabbitViewModel::class)
    fun provideHomeViewModel(vm: RabbitViewModel): ViewModel
}