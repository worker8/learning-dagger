package com.worker8.learningdagger.multibinding.di

import com.worker8.learningdagger.multibinding.AbstractWolf
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WolfModule {
    @Binds
    @IntoMap
    @WolfKey(Wolf::class)
    abstract fun provideWolf(wolf: Wolf): AbstractWolf
}
