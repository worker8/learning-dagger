package com.worker8.learningdagger.di.module

import com.worker8.learningdagger.MainApplication
import com.worker8.learningdagger.di.ApplicationScope
import com.worker8.learningdagger.model.Dog
import dagger.Module
import dagger.Provides

@Module
class ParentModule {
    @Provides
    @ApplicationScope
    fun provideDog(): Dog = Dog("Snoopy", MainApplication.dogCount++)
}