package com.hyundaiautoever.haeproduct.domain.entitylistener

import com.fasterxml.jackson.databind.ObjectMapper
import com.hyundaiautoever.haeproduct.config.event.Event
import com.hyundaiautoever.haeproduct.config.event.EventPublisher
import com.hyundaiautoever.haeproduct.config.event.EventType
import com.hyundaiautoever.haeproduct.domain.history.Historyable
import com.hyundaiautoever.haeproduct.domain.history.HistoryEnum
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
        if (entity is Historyable) {
            val historyType = HistoryEnum.getHistoryType(entity.javaClass.kotlin)
            historyType?.apply {
                val historyJson = objectMapper.writeValueAsString(entity)
                val history = historyType.createNewHistory(0, entity.getEntityId(), historyJson)
                val event = Event(eventType = EventType.HISTORY, eventTitle = historyType.name, eventContent = history)
                val eventJson = objectMapper.writeValueAsString(event)
                eventPublisher.publish(eventJson)
            }
        }
    }
}
