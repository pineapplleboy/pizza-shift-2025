package com.example.pizzashift.shared.data.model

data class PizzaPaymentDTO(
    val receiverAddress: PaymentAddressDTO,
    val person: PaymentPersonDTO,
    val debitCard: PaymentDebitCardDTO,
    val pizzas: List<OrderedPizzaDTO>
)