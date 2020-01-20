package com.worker8.learningdagger.di

import com.worker8.learningdagger.di.module.SubModule
import dagger.Component

@Component(modules = [SubModule::class])
@ActivityScope
interface AppComponentA {
    fun getSubComponentBuilder(): SubComponentA.Builder
}