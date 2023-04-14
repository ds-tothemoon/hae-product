package com.hyundaiautoever.haeproduct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@ConfigurationPropertiesScan
class HaeProductApplication

fun main(args: Array<String>) {
    runApplication<HaeProductApplication>(*args)
}
