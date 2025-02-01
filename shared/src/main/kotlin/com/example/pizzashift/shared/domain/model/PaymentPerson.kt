package com.example.pizzashift.shared.domain.model

data class PaymentPerson(
    val firstName: String,
    val lastName: String,
    val middleName: String? = null,
    val phone: String
)