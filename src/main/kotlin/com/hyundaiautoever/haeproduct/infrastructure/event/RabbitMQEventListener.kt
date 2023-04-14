package com.hyundaiautoever.haeproduct.infrastructure.event

import com.fasterxml.jackson.databind.ObjectMapper
import com.hyundaiautoever.haeproduct.application.HistoryService
import com.hyundaiautoever.haeproduct.config.event.Event
import com.hyundaiautoever.haeproduct.config.event.EventListener
import com.hyundaiautoever.haeproduct.config.event.EventType
import com.hyundaiautoever.haeproduct.domain.ProductHistory
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
        }

        event.onSuccess {
            when (it.eventType) {
                EventType.HISTORY -> {
                    val entity = convertEntity(it)
                    entity?.let {
                        historyService.save(entity)
                    }
                }
            }
        }
    }

    private fun convertEntity(event: Event): Any? {
        if ("productHistory" == event.eventTitle) {
            return objectMapper.convertValue(event.eventContent, ProductHistory::class.java)
        }
        return null
    }
}
