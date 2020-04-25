package com.worker8.learningdagger.multibinding.di

import com.worker8.learningdagger.model.Cat
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

@Module
class MultiMapModule {
    @Provides
    @IntoSet
    fun provideOneString(): String {
        return "ABC"
    }

    @Provides
    @IntoMap
    @StringKey("first")
    fun provideOneDog() = "Doggie"

    @Provides
    @IntoMap
    @IntKey(5)
    fun provideNumberFive() = "five"

    @Provides
    fun giveCat() = Cat("garfield")

}