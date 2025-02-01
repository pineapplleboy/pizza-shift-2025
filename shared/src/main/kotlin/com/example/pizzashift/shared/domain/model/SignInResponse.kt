package com.example.pizzashift.shared.domain.model

data class SignInResponse(
    val success: String,
    val reason: String?,
    val user: User,
    val token: String
)