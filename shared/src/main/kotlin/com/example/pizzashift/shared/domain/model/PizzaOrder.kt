package com.example.pizzashift.shared.domain.model

data class PizzaOrder(
    val pizzas: List<OrderedPizza>,
    val person: PaymentPerson,
    val receiverAddress: PaymentAddress,
    val status: Int,
    val cancellable: Boolean
)