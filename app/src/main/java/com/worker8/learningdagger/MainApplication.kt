package com.worker8.learningdagger

import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        var dogCount = 0
        var turtleCount = 0
    }
}