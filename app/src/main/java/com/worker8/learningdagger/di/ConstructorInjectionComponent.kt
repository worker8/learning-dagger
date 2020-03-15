package com.worker8.learningdagger.di

import com.worker8.learningdagger.ConstructorInjectionActivity
import dagger.Component

@Component
@ActivityScope
interface ConstructorInjectionComponent {
    fun inject(activity: ConstructorInjectionActivity)
}