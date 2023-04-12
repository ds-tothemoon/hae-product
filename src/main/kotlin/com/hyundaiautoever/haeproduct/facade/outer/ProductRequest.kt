package com.hyundaiautoever.haeproduct.facade.outer

import com.hyundaiautoever.haeproduct.domain.Product
data class ProductRegisterDto(
    val productName: String,
    val isActive: Boolean?
) {
    fun toEntity(): Product {
        return Product(id = 0, productName = productName, isActive = isActive ?: false)
    }
}

data class ProductUpdateDto(
    var id: Long,
    val productName: String,
    val isActive: Boolean?
) {
    fun toEntity(): Product {
        return Product(id = id, productName = productName, isActive = isActive ?: false)
    }
}