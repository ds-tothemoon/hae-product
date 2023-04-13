package com.hyundaiautoever.haeproduct.presentation.inner

import com.hyundaiautoever.haeproduct.config.aop.InnerServiceApi
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@InnerServiceApi
@RestController
@RequestMapping("inner")
class InnerProductController {
    @GetMapping
    fun hello(): String = "hello world"
}
