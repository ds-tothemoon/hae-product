package com.hyundaiautoever.haeproduct.application

import org.springframework.web.service.annotation.GetExchange

interface InnerProductService {

    @GetExchange("/inner")
    fun hello(): String
}
