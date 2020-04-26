package com.worker8.learningdagger.model

import android.content.Context

class Coffee(val name: String, val context: Context) {
    val coffeeId = coffeeCounter++

    val identityString by lazy {
        "(name: ${name} #${coffeeId})}"
    }

    companion object {
        var coffeeCounter = 0
    }
}