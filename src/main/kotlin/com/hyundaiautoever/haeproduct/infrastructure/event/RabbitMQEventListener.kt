package com.hyundaiautoever.haeproduct.infrastructure.event

import com.fasterxml.jackson.databind.ObjectMapper
import com.hyundaiautoever.haeproduct.application.HistoryService
import com.hyundaiautoever.haeproduct.config.event.Event
import com.hyundaiautoever.haeproduct.config.event.EventListener
import com.hyundaiautoever.haeproduct.config.event.EventType
import com.hyundaiautoever.haeproduct.domain.history.HistoryBase
import com.hyundaiautoever.haeproduct.domain.history.HistoryEnum
import com.hyundaiautoever.haeproduct.logger
import org.springframework.amqp.AmqpRejectAndDontRequeueException
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitMQEventListener(
    private val objectMapper: ObjectMapper,
    private val historyService: HistoryService
) : EventListener {
    @RabbitListener(queues = ["hae-queue"])
    override fun listen(message: Message?) {
        val event = runCatching {
            objectMapper.readValue(message?.body, Event::class.java)
        }.getOrElse {
            logger().error("Error processing message")
            throw AmqpRejectAndDontRequeueException("Error processing message")
        }

        when (event.eventType) {
            EventType.HISTORY -> {
                convertEntity(event)?.let { historyService.save(it) }
            }
        }
    }

    private fun convertEntity(event: Event): HistoryBase? = try {
        val historyEnum = HistoryEnum.valueOf(event.eventTitle)
        objectMapper.convertValue(event.eventContent, historyEnum.historyClazz.java)
    } catch (ex: IllegalArgumentException) {
        logger().error("IllegalArgumentException in ${this.javaClass}")
        null
    }
}
