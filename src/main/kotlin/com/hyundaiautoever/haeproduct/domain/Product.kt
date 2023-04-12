package com.hyundaiautoever.haeproduct.domain

import com.hyundaiautoever.haeproduct.infrastructure.jpa.converter.BooleanToYNConverter
import jakarta.persistence.*

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var productName: String,
    @Convert(converter = BooleanToYNConverter::class)
    var isActive: Boolean = false
) : BaseEntity() {
    fun update(product: Product) {
        productName = product.productName
        isActive = product.isActive
    }
}