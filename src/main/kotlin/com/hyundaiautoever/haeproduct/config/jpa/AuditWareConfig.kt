package com.hyundaiautoever.haeproduct.config.jpa

import com.hyundaiautoever.haeproduct.config.auth.UserContextHolder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.*

@Configuration
@EnableJpaAuditing
class AuditWareConfig {

    @Bean
    fun auditorProvider(): AuditorAware<Long> {
        return CustomAuditorAware()
    }
}

private class CustomAuditorAware : AuditorAware<Long> {
    override fun getCurrentAuditor(): Optional<Long> {
        val user = UserContextHolder.getUserContext()
        return Optional.of(user?.id ?: -1)
    }
}
