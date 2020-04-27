package com.worker8.learningdagger.multibinding_viewmodel.jackRabbitMVVM

interface JackRabbitRepositoryInterface {
    suspend fun fetchNames(): List<String>
}