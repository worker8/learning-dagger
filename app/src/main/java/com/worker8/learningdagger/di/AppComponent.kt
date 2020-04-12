package com.worker8.learningdagger.di

import com.worker8.learningdagger.CatActivity
import com.worker8.learningdagger.MainActivity
import com.worker8.learningdagger.ScopeActivity
import com.worker8.learningdagger.di.module.AnimalModule
import com.worker8.learningdagger.di.module.PersonModule
import dagger.Component

@Component(modules = [PersonModule::class, AnimalModule::class])
@ApplicationScope
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: CatActivity)
    fun inject(activity: ScopeActivity)
}