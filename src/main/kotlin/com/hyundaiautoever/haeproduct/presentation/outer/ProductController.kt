package com.hyundaiautoever.haeproduct.presentation.outer

import com.hyundaiautoever.haeproduct.application.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(val productService: ProductService) {

    @GetMapping("{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<String> {
        val product = productService.getProduct(id)
        print(product.auditLog)
        return ResponseEntity
            .ok()
            .body(product.toString())
    }

    @PostMapping("register")
    fun registerProduct(@RequestBody productDto: ProductRegisterDto): Long {
        return productService.registerProduct(productDto.toEntity())
    }

    @PutMapping("update/{id}")
    fun updateProduct(
        @PathVariable id: Long,
        @RequestBody productDto: ProductUpdateDto
    ): Long {
        productDto.id = id
        return productService.updateProduct(productDto.toEntity())
    }
}
