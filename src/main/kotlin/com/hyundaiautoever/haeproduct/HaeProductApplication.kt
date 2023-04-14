package com.hyundaiautoever.haeproduct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class HaeProductApplication

fun main(args: Array<String>) {
    runApplication<HaeProductApplication>(*args)
}
