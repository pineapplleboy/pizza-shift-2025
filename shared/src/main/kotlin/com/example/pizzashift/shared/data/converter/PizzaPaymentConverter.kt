package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.PizzaPaymentDTO
import com.example.pizzashift.shared.domain.model.PizzaPayment

fun PizzaPayment.toDTO(): PizzaPaymentDTO {

    return PizzaPaymentDTO(
        pizzas = this.pizzas.map { it.toDTO() },
        debitCard = this.debitCard.toDTO(),
        person = this.person.toDTO(),
        receiverAddress = this.receiverAddress.toDTO()
    )
}