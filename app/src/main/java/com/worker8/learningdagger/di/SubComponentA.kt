package com.worker8.learningdagger.di

import android.content.Context
import com.worker8.learningdagger.FakeFragment
import com.worker8.learningdagger.di.module.BeverageModule
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [BeverageModule::class])
@PerSubComponentScope
interface SubComponentA {
    fun inject(fakeFragment: FakeFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): SubComponentA

        @BindsInstance
        fun bindContext(context: Context): Builder
    }
}