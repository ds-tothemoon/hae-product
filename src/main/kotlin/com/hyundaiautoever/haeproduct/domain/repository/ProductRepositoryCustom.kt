package com.hyundaiautoever.haeproduct.domain.repository

import com.hyundaiautoever.haeproduct.domain.Product

interface ProductRepositoryCustom {
    fun searchProducts(name: String): List<Product>
}
