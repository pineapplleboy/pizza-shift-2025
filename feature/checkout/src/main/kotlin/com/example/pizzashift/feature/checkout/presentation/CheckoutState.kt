package com.example.pizzashift.feature.checkout.presentation

import com.example.pizzashift.shared.domain.model.PizzaPayment

sealed interface CheckoutState {

    data object Loading : CheckoutState

    data object FirstPart : CheckoutState

    data object SecondPart : CheckoutState

    data class Success(
        val paymentPrice: String,
        val pizzasDescription: String,
        val pizzaPayment: PizzaPayment
    ) : CheckoutState

    data class Failure(val message: String) : CheckoutState
}