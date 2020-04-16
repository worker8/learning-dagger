package com.worker8.learningdagger.subcomponent.di

import android.content.Context
import com.worker8.learningdagger.model.Coffee
import dagger.Module
import dagger.Provides

@Module
class ChildModule {
    @Provides
    @ParentScope
    fun provideLatte(context: Context): Coffee = Coffee("Latte", context)
}