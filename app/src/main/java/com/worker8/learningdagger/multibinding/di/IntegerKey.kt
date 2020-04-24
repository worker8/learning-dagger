package com.worker8.learningdagger.multibinding.di

import dagger.MapKey

//@MapKey
//annotation class IntegerKey(val value: KClass<out Int>)


@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class IntegerKey(val value: Int)
