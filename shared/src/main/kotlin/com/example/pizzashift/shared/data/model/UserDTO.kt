package com.example.pizzashift.shared.data.model

data class UserDTO(
    val phone: String,
    val firstname: String?,
    val lastname: String?,
    val middlename: String?,
    val email: String?,
    val city: String?
)