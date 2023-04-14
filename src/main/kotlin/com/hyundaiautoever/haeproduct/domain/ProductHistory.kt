package com.hyundaiautoever.haeproduct.domain

import com.hyundaiautoever.haeproduct.domain.vo.AuditLog
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class)
@Entity
class ProductHistory(
    id: Long = 0,
    productNo: Long,
    content: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    var productNo: Long = productNo

    var content: String = content

    @Embedded
    var auditLog: AuditLog = AuditLog()
        private set
}
