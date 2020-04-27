package com.worker8.learningdagger.multibinding_viewmodel.rabbitMVVM

import android.content.Context
import android.util.Log
import kotlinx.coroutines.delay

class RabbitRepository constructor(val context: Context) : RabbitRepositoryInterface {
    override suspend fun fetchNames(): List<String> {
        Log.d("ddw", "fetchNames in Thread: ${Thread.currentThread().name}")
        delay(1000)
        return listOf(
            "Aaren",
            "Aarika",
            "Abagael",
            "Abagail",
            "Abbe",
            "Abbey",
            "Abbi",
            "Abbie",
            "Abby",
            "Abbye",
            "Abigael",
            "Abigail",
            "Abigale",
            "Anabal"
        )
    }
}