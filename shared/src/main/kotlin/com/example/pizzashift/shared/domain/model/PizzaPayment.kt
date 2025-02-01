package com.example.pizzashift.shared.domain.model

data class PizzaPayment(
    val receiverAddress: PaymentAddress,
    val person: PaymentPerson,
    val debitCard: PaymentDebitCard,
    val pizzas: List<OrderedPizza>
)