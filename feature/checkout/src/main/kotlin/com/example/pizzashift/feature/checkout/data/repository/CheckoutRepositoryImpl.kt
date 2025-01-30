package com.example.pizzashift.feature.checkout.data.repository

import com.example.pizzashift.feature.checkout.domain.repository.CheckoutRepository
import com.example.pizzashift.shared.data.converter.toDTO
import com.example.pizzashift.shared.domain.model.PizzaPayment
import com.example.pizzashift.shared.data.network.PizzaApi

class CheckoutRepositoryImpl(
    private val api: PizzaApi
): CheckoutRepository {

    override suspend fun orderPizza(payment: PizzaPayment) {
        api.orderPizza(payment.toDTO())
    }
}