package com.worker8.learningdagger.model

import android.content.Context
import android.util.Log
import com.worker8.learningdagger.identityHashCode

class Coffee(val name: String, val context: Context) {
    fun printContext() {
        Log.d(
            "ddw",
            "(${identityHashCode()}) name: ${name}, context: ${context.identityHashCode()}"
        )
    }
}