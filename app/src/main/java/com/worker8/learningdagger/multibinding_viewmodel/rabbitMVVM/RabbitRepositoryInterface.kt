package com.worker8.learningdagger.multibinding_viewmodel.rabbitMVVM

interface RabbitRepositoryInterface {
    suspend fun fetchNames(): List<String>
}