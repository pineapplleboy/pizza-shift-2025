package com.example.pizzashift.shared.data.model

data class PaymentAddressDTO(
    val street: String,
    val house: String,
    val apartment: String,
    val comment: String?
)