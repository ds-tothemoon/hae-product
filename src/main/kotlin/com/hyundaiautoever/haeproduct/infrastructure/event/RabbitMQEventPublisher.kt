package com.hyundaiautoever.haeproduct.infrastructure.event

import com.hyundaiautoever.haeproduct.config.event.EventPublisher
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class RabbitMQEventPublisher(
    private val rabbitTemplate: RabbitTemplate
) : EventPublisher {
    override fun publish(message: String) {
        rabbitTemplate.convertAndSend("hae-queue", message)
    }
}
