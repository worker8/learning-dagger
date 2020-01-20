package com.worker8.learningdagger.di.module

import com.worker8.learningdagger.model.Person
import dagger.Module
import dagger.Provides

@Module
class PersonModule {
    @Provides
    fun providePerson(): Person =
        Person(
            name = "Dagger Jim",
            pet = "Dagger Little Puppy",
            favoriteColor = "Dagger Blue"
        )
}