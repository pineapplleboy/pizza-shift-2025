package com.example.pizzashift.shared.domain.model

data class User(
    val phone: String,
    val firstname: String?,
    val lastname: String?,
    val middlename: String?,
    val email: String?,
    val city: String?
)