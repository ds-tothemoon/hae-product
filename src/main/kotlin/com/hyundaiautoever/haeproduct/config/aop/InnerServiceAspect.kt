package com.hyundaiautoever.haeproduct.config.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class InnerServiceApi

@Aspect
@Component
class InnerServiceAspect {
    @Value("\${hae.inner-token}")
    private lateinit var innerToken: String

    @Before("@within(InnerServiceApi)")
    fun validateInnerToken(joinPoint: JoinPoint) {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        val token = request.getHeader("X-INNER-TOKEN")

        if (innerToken != token) {
            throw RuntimeException("invalid inner token")
        }
    }
}
