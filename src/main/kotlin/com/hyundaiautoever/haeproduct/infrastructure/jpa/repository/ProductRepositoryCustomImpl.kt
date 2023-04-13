package com.hyundaiautoever.haeproduct.infrastructure.jpa.repository

import com.hyundaiautoever.haeproduct.domain.Product
import com.hyundaiautoever.haeproduct.domain.ProductRepositoryCustom
import com.hyundaiautoever.haeproduct.domain.QProduct
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryCustomImpl(val jpaQueryFactory: JPAQueryFactory) : ProductRepositoryCustom {
    override fun searchProducts(name: String): List<Product> {
        val qProduct = QProduct.product
        return jpaQueryFactory
            .selectFrom(qProduct)
            .where(qProduct.productName.like("%$name%"))
            .fetch()
    }
}
