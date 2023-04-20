package com.hyundaiautoever.haeproduct.domain.entity.product

import com.hyundaiautoever.haeproduct.domain.entity.vo.AuditLog
import com.hyundaiautoever.haeproduct.domain.entity.vo.Money
import com.hyundaiautoever.haeproduct.domain.entitylistener.HistoryEntityListener
import com.hyundaiautoever.haeproduct.domain.history.Historyable
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.math.BigDecimal
import java.time.LocalDateTime

@EntityListeners(AuditingEntityListener::class, HistoryEntityListener::class)
class Vehicle(
    id: Long,
    carModelCode: String,
    carNameCode: String,
    carName: String,
    year: String,
    basePrice: Money,
    minContactPrice: BigDecimal,
    saleStartDate: LocalDateTime,
    saleEndDate: LocalDateTime,
    representationImage: String,
) : Historyable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    var carModelCode: String = carModelCode
        private set

    var carNameCode: String = carNameCode
        private set

    var carName: String = carName
        private set

    var year: String = year
        private set

    var basePrice: Money = basePrice
        private set

    var minContactPrice: BigDecimal = minContactPrice
        private set

    var saleStartDate: LocalDateTime = saleStartDate
        private set

    var saleEndDate: LocalDateTime = saleEndDate
        private set

    var representationImage: String = representationImage
        private set

    @Embedded
    var auditLog: AuditLog = AuditLog()
        private set

    override fun getEntityId(): Long = id
}
