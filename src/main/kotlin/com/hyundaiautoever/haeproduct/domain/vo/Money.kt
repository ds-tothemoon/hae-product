package com.hyundaiautoever.haeproduct.domain.vo

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
data class Money(
    @Column(name = "amount")
    val amount: BigDecimal,
    @Column(name = "currency")
    val currency: String
)