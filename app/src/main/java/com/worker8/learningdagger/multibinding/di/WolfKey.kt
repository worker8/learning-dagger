package com.worker8.learningdagger.multibinding.di

import com.worker8.learningdagger.multibinding.AbstractWolf
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
annotation class WolfKey(val value: KClass<out AbstractWolf>)