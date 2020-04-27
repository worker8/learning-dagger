package com.worker8.learningdagger.componentBuilder.di

import com.worker8.learningdagger.componentBuilder.CBRepository
import dagger.Module
import dagger.Provides

@Module
class CBRepositoryModule(val temp: String = "") {
    @Provides
    fun provideCBRepository(): CBRepository {
        if (temp.isBlank()) {
            return CBRepository("It's blank")
        } else {
            return CBRepository(temp)
        }
    }
}