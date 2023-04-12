package com.hyundaiautoever.haeproduct.config

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JpaConfig {
    @PersistenceContext
    lateinit var em: EntityManager
}