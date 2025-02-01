package com.example.pizzashift.shared.data.model

data class SignInResponseDTO(
    val success: String,
    val reason: String?,
    val user: UserDTO,
    val token: String
)