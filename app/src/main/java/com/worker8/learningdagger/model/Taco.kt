package com.worker8.learningdagger.model

import com.worker8.learningdagger.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class Taco @Inject constructor() {
    val name: String = "Chicken Taco"
}