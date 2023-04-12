package com.hyundaiautoever.haeproduct.domain.vo

import jakarta.persistence.Embeddable
import java.math.BigDecimal

@Embeddable
class Money(
    amount: BigDecimal,
    currency: String
) {
    var amount: BigDecimal = amount
        protected set
    var currency: String = currency
        protected set

    constructor() : this(BigDecimal.ZERO, "")
}
