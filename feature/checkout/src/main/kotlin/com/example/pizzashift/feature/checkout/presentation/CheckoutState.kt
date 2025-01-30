package com.example.pizzashift.feature.checkout.presentation

sealed interface CheckoutState {

    data object Loading : CheckoutState

    data object Initial : CheckoutState

    data class Failure(val message: String) : CheckoutState

    data object Content: CheckoutState
}