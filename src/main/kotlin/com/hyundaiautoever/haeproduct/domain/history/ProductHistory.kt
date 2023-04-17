package com.hyundaiautoever.haeproduct.domain.history

import com.hyundaiautoever.haeproduct.domain.vo.AuditLog
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class)
@Entity
class ProductHistory(
    id: Long = 0,
    entityNo: Long,
    content: String,
) : HistoryBase(entityNo = entityNo, content = content) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    @Column(name = "productNo")
    var entityNo: Long = entityNo
        private set
    var content: String = content
        private set
    @Embedded
    var auditLog: AuditLog = AuditLog()
        private set
}
