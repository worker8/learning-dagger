package com.worker8.learningdagger.multibinding.di

import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey
import kotlin.reflect.KClass

@MapKey
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class MyNumberClassKey(val value: KClass<out Number>)

@Module
object MultiMapModule {
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
    @JvmStatic
    fun provideNumberFive() = "five"

//    @JvmStatic
//    @Provides
//    @IntoMap
//    @MyNumberClassKey(BigDecimal::class)
//    fun provideBigDecimalValue() = "value for BigDecimal"

//    @Provides
//    @IntoMap
//    @CatKey(Cat::class)
//    fun provideOneCatFromClass(): String {
//        return "Garfield"
//    }
}
