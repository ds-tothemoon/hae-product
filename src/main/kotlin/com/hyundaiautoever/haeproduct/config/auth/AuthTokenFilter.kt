package com.hyundaiautoever.haeproduct.config.auth

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class AuthTokenFilter() : Filter {
    @Value("\${hae.service.auth.url}")
    private lateinit var AUTH_URL: String
    private val AUTHORIZATION = "Authorization"

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        if (request is HttpServletRequest) {
            request.getHeader(AUTHORIZATION)?.let { token ->
                val user = getUserFromAuthService(token)
                UserContextHolder.setUserContext(user)
            }
        }
        chain?.doFilter(request, response)
        UserContextHolder.clearUserContext()
    }

    private fun getUserFromAuthService(token: String): User? {
        return webClient().get()
            .uri("$AUTH_URL/auth/me")
            .header(AUTHORIZATION, token)
            .retrieve()
            .bodyToMono(User::class.java)
            .block()
    }

    fun webClient() = WebClient.create()
}
