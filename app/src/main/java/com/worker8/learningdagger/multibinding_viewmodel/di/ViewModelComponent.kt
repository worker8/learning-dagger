package com.worker8.learningdagger.multibinding.di

import com.worker8.learningdagger.di.ApplicationScope
import com.worker8.learningdagger.multibinding.MultiBindingViewModelActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class, WolfModule::class])
@ApplicationScope
interface ViewModelComponent {
    fun inject(activity: MultiBindingViewModelActivity)
}