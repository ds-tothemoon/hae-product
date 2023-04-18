package com.hyundaiautoever.haeproduct.domain.repository

import com.hyundaiautoever.haeproduct.domain.Product
import java.util.Optional

interface ProductRepository {
    fun findById(id: Long): Optional<Product>
    fun save(product: Product): Product
}