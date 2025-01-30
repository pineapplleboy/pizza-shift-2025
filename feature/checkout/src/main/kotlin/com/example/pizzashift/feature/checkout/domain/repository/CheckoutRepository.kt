package com.example.pizzashift.feature.checkout.domain.repository

import com.example.pizzashift.shared.domain.model.PizzaPayment

interface CheckoutRepository {

    suspend fun orderPizza(payment: PizzaPayment)
}