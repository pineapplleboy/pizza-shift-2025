package com.example.pizzashift.shared.data.model

data class OtpResponseDTO(
    val success: Boolean,
    val reason: String?,
    val retryDelay: Int
)