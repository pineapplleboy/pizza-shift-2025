package com.example.pizzashift.shared.data.model

data class PaymentDebitCardDTO(
    val pan: String,
    val expireDate: String,
    val cvv: String
)