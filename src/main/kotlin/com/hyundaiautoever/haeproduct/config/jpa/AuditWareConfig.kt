package com.hyundaiautoever.haeproduct.config.jpa

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
        // TODO 현재 사용자 Id 가져오는 건 추후 구현 (Spring Security 이용 시 SecurityContextHolder 사용)
        return Optional.of(999)
    }
}
