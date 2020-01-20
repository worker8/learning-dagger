package com.worker8.learningdagger.di.module

import com.worker8.learningdagger.di.ActivityScope
import com.worker8.learningdagger.model.Cat
import com.worker8.learningdagger.model.Dog
import com.worker8.learningdagger.model.Turtle
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AnimalModule {

    @Provides
    @Named("Garfield")
    fun provideGarfield(): Cat = Cat("Garfield")

    @Provides
    @Named("HelloKitty")
    fun provideHelloKitty(): Cat = Cat("Hello Kitty")

    @Provides
    fun provideSnoopy(): Dog = Dog("Snoopy")

    @Provides
    @ActivityScope
    fun provideTurtle(): Turtle = Turtle("Master Oogway")
}