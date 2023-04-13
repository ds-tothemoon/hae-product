package com.hyundaiautoever.haeproduct.infrastructure.http.config

import com.hyundaiautoever.haeproduct.application.InnerProductService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class HttpConfiguration {
    @Value("\${hae.inner-token}")
    private lateinit var innerToken: String

    @Value("\${hae.service.product.url}")
    private lateinit var PRODUCT_URL: String

    @Bean
    fun innerProductService(): InnerProductService {
        val webClient = WebClient.builder()
            .baseUrl(PRODUCT_URL)
            .defaultHeader("X-INNER-TOKEN", innerToken)
            .build()

        val factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build()
        return factory.createClient(InnerProductService::class.java)
    }
}
