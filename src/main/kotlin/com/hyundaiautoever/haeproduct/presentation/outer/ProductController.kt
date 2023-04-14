package com.hyundaiautoever.haeproduct.presentation.outer

import com.hyundaiautoever.haeproduct.application.InnerProductService
import com.hyundaiautoever.haeproduct.application.ProductService
import com.hyundaiautoever.haeproduct.config.event.EventPublisher
import com.hyundaiautoever.haeproduct.domain.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(
    val productService: ProductService,
    val innerProductService: InnerProductService,
    val eventPublisher: EventPublisher
) {

    @GetMapping("{id}")
    fun getProduct(@PathVariable id: Long): ResponseEntity<String> {
        val product = productService.getProduct(id)
        print(product.auditLog)
        return ResponseEntity
            .ok()
            .body(product.toString())
    }

    @GetMapping("search")
    fun searchProduct(@RequestParam keyword: String): List<Product> {
        return productService.searchProduct(keyword)
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

    @GetMapping("inner")
    fun test() = innerProductService.hello()

    @PostMapping("event/publish")
    fun publishEvent(@RequestBody event: String) {
        eventPublisher.publish(event)
    }
}
