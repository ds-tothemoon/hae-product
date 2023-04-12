package com.hyundaiautoever.haeproduct.domain

import java.util.Optional

interface ProductRepository{
    fun findById(id: Long): Optional<Product>
    fun save(product: Product): Product
}