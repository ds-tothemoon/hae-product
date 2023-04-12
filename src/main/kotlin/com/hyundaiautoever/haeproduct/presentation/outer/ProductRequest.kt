package com.hyundaiautoever.haeproduct.presentation.outer

import com.hyundaiautoever.haeproduct.domain.Product
import com.hyundaiautoever.haeproduct.domain.vo.Money
import java.math.BigDecimal

data class ProductRegisterDto(
    val productName: String,
    val isActive: Boolean?,
    val amount: BigDecimal,
    val currency: String = "won"
) {
    fun toEntity(): Product {
        val price = Money(amount = amount, currency = currency)
        return Product(id = 0, productName = productName, isActive = isActive ?: false, price = price)
    }
}

data class ProductUpdateDto(
    var id: Long,
    val productName: String,
    val isActive: Boolean?,
    val amount: BigDecimal,
    val currency: String = "won"
) {
    fun toEntity(): Product {
        val price = Money(amount = amount, currency = currency)
        return Product(id = id, productName = productName, isActive = isActive ?: false, price = price)
    }
}
