package com.hyundaiautoever.haeproduct.config.auth

import org.springframework.web.service.annotation.GetExchange

interface AuthService {
    @GetExchange("/auth/me")
    fun getUser(): String
}
