package com.worker8.learningdagger.subcomponent.di

import android.content.Context
import com.worker8.learningdagger.subcomponent.ChildFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [ChildModule::class])
@ParentScope
interface ChildComponent {
    fun inject(childFragment: ChildFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ChildComponent

        @BindsInstance
        fun bindContext(context: Context): Builder
    }
}