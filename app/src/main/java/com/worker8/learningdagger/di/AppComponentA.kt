package com.worker8.learningdagger.di

import com.worker8.learningdagger.di.module.SubModule
import dagger.Component

@Component(modules = [SubModule::class])
@ApplicationScope
interface AppComponentA {
    fun getSubComponent(): SubComponentA.Builder
}