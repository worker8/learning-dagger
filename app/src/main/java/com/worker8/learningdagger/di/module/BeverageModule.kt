package com.worker8.learningdagger.di.module

import android.content.Context
import com.worker8.learningdagger.di.PerSubComponentScope
import com.worker8.learningdagger.model.Coffee
import dagger.Module
import dagger.Provides

@Module
class BeverageModule {
    @Provides
    @PerSubComponentScope
    fun provideLatte(context: Context): Coffee = Coffee("Latte", context)
}