package com.hyundaiautoever.haeproduct.domain.history

import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class HistoryBase(
    id: Long = 0,
    entityNo: Long,
    content: String,
)
