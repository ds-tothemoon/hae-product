package com.hyundaiautoever.haeproduct.application

import com.hyundaiautoever.haeproduct.domain.Product
import com.hyundaiautoever.haeproduct.domain.history.ProductHistory
import com.hyundaiautoever.haeproduct.domain.ProductRepository
import com.hyundaiautoever.haeproduct.domain.ProductRepositoryCustom
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class ProductService(
    val productRepository: ProductRepository,
    val productRepositoryCustom: ProductRepositoryCustom
) {

    fun getProduct(id: Long): Product {
        return productRepository.findById(id)
            .orElseThrow { RuntimeException("cannot find product by $id") }
    }
    @Transactional
    fun registerProduct(product: Product): Long {
        val savedProduct = productRepository.save(product)
        return savedProduct.id
    }

    @Transactional
    fun updateProduct(product: Product): Long {
        val productForUpdate = productRepository.findById(product.id)
            .map { it }
            .orElseThrow { RuntimeException("cannot find product by ${product.id}") }
        productForUpdate.update(product)

        return productForUpdate.id
    }

    fun searchProduct(keyword: String): List<Product> {
        return productRepositoryCustom.searchProducts(keyword)
    }

    fun registerProductHistory(productHistory: ProductHistory) {
        println(productHistory)
    }
}
