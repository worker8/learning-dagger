package com.worker8.learningdagger.model

import android.content.Context
import com.worker8.learningdagger.identityHashCode

class Coffee(val name: String, val context: Context) {
    val coffeeId = coffeeCounter++

    val identityString by lazy {
        "(name: ${name} #${coffeeId}), context: ${context.identityHashCode()}"
    }

    companion object {
        var coffeeCounter = 0
    }
}