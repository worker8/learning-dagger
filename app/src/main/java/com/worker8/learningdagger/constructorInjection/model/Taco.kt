package com.worker8.learningdagger.constructorInjection.model

import com.worker8.learningdagger.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class Taco @Inject constructor() {
    val name: String = "Chicken Taco"
}