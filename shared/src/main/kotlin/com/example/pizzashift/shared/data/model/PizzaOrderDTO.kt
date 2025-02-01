package com.example.pizzashift.shared.data.model

data class PizzaOrderDTO(
    val pizzas: List<OrderedPizzaDTO>,
    val person: PaymentPersonDTO,
    val receiverAddress: PaymentAddressDTO,
    val status: Int,
    val cancellable: Boolean
)