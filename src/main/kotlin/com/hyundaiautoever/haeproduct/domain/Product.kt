package com.hyundaiautoever.haeproduct.domain

import com.hyundaiautoever.haeproduct.domain.entitylistener.HistoryEntityListener
import com.hyundaiautoever.haeproduct.domain.history.Historyable
import com.hyundaiautoever.haeproduct.domain.vo.AuditLog
import com.hyundaiautoever.haeproduct.domain.vo.Money
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class, HistoryEntityListener::class)
@Entity
class Product(
    id: Long,
    productName: String,
    price: Money,
    isActive: Boolean
) : Historyable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = id

    @Embedded
    var price: Money = price
        private set

    var isActive: Boolean = isActive
        private set
    var productName: String = productName
        private set

    @Embedded
    var auditLog: AuditLog = AuditLog()
        private set

    fun update(product: Product) {
        productName = product.productName
        isActive = product.isActive
        price = product.price
    }

    override fun getEntityId(): Long = id
}
