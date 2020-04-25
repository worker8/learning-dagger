package com.worker8.learningdagger.multibinding.di

import com.worker8.learningdagger.di.ApplicationScope
import com.worker8.learningdagger.multibinding.MultiBindingActivity
import dagger.Component

@Component(modules = [MultiMapModule::class, WolfModule::class])
@ApplicationScope
interface MultiMapComponent {
    fun inject(activity: MultiBindingActivity)
}