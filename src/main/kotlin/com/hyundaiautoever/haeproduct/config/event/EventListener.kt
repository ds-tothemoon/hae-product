package com.hyundaiautoever.haeproduct.config.event

import org.springframework.amqp.core.Message

interface EventListener {
    fun listen(message: Message?)
}
