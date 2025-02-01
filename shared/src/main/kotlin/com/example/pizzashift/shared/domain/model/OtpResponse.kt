package com.example.pizzashift.shared.domain.model

data class OtpResponse(
    val success: Boolean,
    val reason: String?,
    val retryDelay: Int
)