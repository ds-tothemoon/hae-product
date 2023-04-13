package com.hyundaiautoever.haeproduct.domain

interface ProductRepositoryCustom {
    fun searchProducts(name: String): List<Product>
}
