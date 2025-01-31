package com.example.pizzashift.shared.domain.model

data class PaymentAddress(
    val street: String,
    val house: String,
    val apartment: String,
    val comment: String?
)