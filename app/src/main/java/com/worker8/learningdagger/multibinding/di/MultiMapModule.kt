package com.worker8.learningdagger.multibinding.di

import dagger.Module
import dagger.Provides
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

//    @Provides
//    @IntoMap
//    @IntegerKey(Integer::class)
//    fun provideNumberFive() = 5

//    @Provides
//    @IntoMap
//    @CatKey(Cat::class)
//    fun provideOneCatFromClass(): String {
//        return "Garfield"
//    }
}
