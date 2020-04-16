package com.worker8.learningdagger.constructorInjection.model

import javax.inject.Inject

class ChickenFajita @Inject constructor() {
    val name: String = "Chicken Fajita"
}