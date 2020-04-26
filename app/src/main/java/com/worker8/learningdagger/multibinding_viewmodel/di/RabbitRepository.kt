package com.worker8.learningdagger.multibinding_viewmodel.di

import android.content.Context
import kotlinx.coroutines.delay
import javax.inject.Inject

class RabbitRepository @Inject constructor(val context: Context) : RabbitRepositoryInterface {
    suspend fun fetchNames(): List<String> {
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