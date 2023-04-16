package com.hyundaiautoever.haeproduct.domain.history

import com.hyundaiautoever.haeproduct.domain.history.HistoryBase
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

    var content: String = content

    @Embedded
    var auditLog: AuditLog = AuditLog()
        private set
}
