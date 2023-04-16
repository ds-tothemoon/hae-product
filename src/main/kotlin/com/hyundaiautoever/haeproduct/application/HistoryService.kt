package com.hyundaiautoever.haeproduct.application

import com.hyundaiautoever.haeproduct.domain.history.HistoryBase
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HistoryService {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Transactional
    fun save(entity: HistoryBase) {
        entityManager.persist(entity)
    }
}
