package com.hyundaiautoever.haeproduct.domain.entitylistener

import com.fasterxml.jackson.databind.ObjectMapper
import com.hyundaiautoever.haeproduct.config.event.Event
import com.hyundaiautoever.haeproduct.config.event.EventPublisher
import com.hyundaiautoever.haeproduct.config.event.EventType
import com.hyundaiautoever.haeproduct.domain.Product
import com.hyundaiautoever.haeproduct.domain.ProductHistory
import jakarta.persistence.PostPersist
import jakarta.persistence.PostUpdate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class HistoryEntityListener {
    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var eventPublisher: EventPublisher

    @PostPersist
    @PostUpdate
    fun preUpdate(entity: Any) {
        if (entity is Product) {
            val productJson = objectMapper.writeValueAsString(entity)
            val history = ProductHistory(id = 0, productNo = entity.id, content = productJson)
            val event = Event(eventType = EventType.HISTORY, eventTitle = "productHistory", eventContent = history)
            val eventJson = objectMapper.writeValueAsString(event)
            eventPublisher.publish(eventJson)
        }
    }
}
