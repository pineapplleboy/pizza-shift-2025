package com.example.pizzashift.feature.checkout.domain.usecase

import com.example.pizzashift.feature.checkout.domain.repository.CheckoutRepository
import com.example.pizzashift.shared.domain.model.PizzaPayment

class OrderPizzaUseCase(
    private val repository: CheckoutRepository
) {
    suspend operator fun invoke(payment: PizzaPayment) {
        repository.orderPizza(payment)
    }
}