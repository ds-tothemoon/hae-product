package com.hyundaiautoever.haeproduct.domain

import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    var createdAt: LocalDateTime = LocalDateTime.now()

    @CreatedBy
    var createdBy: Long? = null

    var updatedAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedBy
    var updatedBy: Long? = null
}