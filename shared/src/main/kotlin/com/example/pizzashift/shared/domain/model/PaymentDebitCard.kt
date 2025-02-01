package com.example.pizzashift.shared.domain.model

data class PaymentDebitCard(
    val pan: String,
    val expireDate: String,
    val cvv: String
)