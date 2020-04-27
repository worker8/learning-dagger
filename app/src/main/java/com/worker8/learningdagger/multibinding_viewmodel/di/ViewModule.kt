package com.worker8.learningdagger.multibinding.di

import androidx.lifecycle.ViewModel
import com.worker8.learningdagger.multibinding.JackRabbitViewModel
import com.worker8.learningdagger.multibinding.RabbitViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModule {
    @Binds
    @IntoMap
    @ViewModelKey(RabbitViewModel::class)
    fun provideRabbitViewModel(vm: RabbitViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(JackRabbitViewModel::class)
    fun provideJackRabbitViewModel(vm: JackRabbitViewModel): ViewModel
}