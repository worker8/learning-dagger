package com.worker8.learningdagger.constructorInjection.di

import com.worker8.learningdagger.constructorInjection.ConstructorInjectionActivity
import com.worker8.learningdagger.di.ApplicationScope
import dagger.Component

@Component
@ApplicationScope
interface ConstructorInjectionComponent {
    fun inject(activity: ConstructorInjectionActivity)
}