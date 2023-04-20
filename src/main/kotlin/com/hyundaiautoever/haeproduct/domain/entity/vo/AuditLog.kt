package com.hyundaiautoever.haeproduct.domain.entity.vo

import jakarta.persistence.Embeddable
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Embeddable
data class AuditLog(
    @CreatedDate
    var createdAt: LocalDateTime? = null,

    @CreatedBy
    var createdBy: Long? = null,

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null,

    @LastModifiedBy
    var updatedBy: Long? = null
)
