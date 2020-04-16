package com.worker8.learningdagger.subcomponent.di

import com.worker8.learningdagger.di.ApplicationScope
import com.worker8.learningdagger.di.module.ParentModule
import dagger.Component

@Component(modules = [ParentModule::class])
@ApplicationScope
interface ParentComponent {
    fun getSubComponent(): ChildComponent.Builder
}