package com.hyundaiautoever.haeproduct.config.auth

import java.time.LocalDateTime

data class User(
    val id: Long,
    val profileUrl: String?,
    val username: String,
    val email: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
)
