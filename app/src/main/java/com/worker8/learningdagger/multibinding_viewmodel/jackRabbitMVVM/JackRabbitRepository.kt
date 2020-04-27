package com.worker8.learningdagger.multibinding_viewmodel.jackRabbitMVVM

import android.content.Context
import kotlinx.coroutines.delay
import javax.inject.Inject

class JackRabbitRepository @Inject constructor(val context: Context) :
    JackRabbitRepositoryInterface {
    override suspend fun fetchNames(): List<String> {
        delay(1000)
        return listOf(
            "JackRabbit - Aaren",
            "JackRabbit - Aarika",
            "JackRabbit - Abagael",
            "JackRabbit - Abagail",
            "JackRabbit - Abbe",
            "JackRabbit - Abbey",
            "JackRabbit - Abbi",
            "JackRabbit - Abbie",
            "JackRabbit - Abby",
            "JackRabbit - Abbye",
            "JackRabbit - Abigael",
            "JackRabbit - Abigail",
            "JackRabbit - Abigale",
            "JackRabbit - Anabal"
        )
    }
}