package com.worker8.learningdagger.multibinding.di

import com.worker8.learningdagger.model.Cat
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class CatKey(val value: KClass<out Cat>)