package com.hyundaiautoever.haeproduct.config.event

interface EventPublisher {
    fun publish(message: String)
}
