package com.hyundaiautoever.haeproduct.infrastructure.jpa.repository

import com.hyundaiautoever.haeproduct.domain.Product
import com.hyundaiautoever.haeproduct.domain.repository.ProductRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaProductRepository : JpaRepository<Product, Long>, ProductRepository