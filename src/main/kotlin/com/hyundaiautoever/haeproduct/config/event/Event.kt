package com.hyundaiautoever.haeproduct.config.event

enum class EventType {
    HISTORY
}

data class Event(
    val eventType: EventType,
    val eventTitle: String,
    val eventContent: Any,
)
