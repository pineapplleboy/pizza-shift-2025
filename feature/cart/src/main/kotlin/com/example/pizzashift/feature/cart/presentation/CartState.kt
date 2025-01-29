package com.example.pizzashift.feature.cart.presentation

import com.example.pizzashift.shared.domain.model.OrderedPizza

sealed interface CartState {
    data object Initial : CartState
    data object Loading : CartState
    data class Failure(val message: String?) : CartState
    data class Content(val pizzas: List<OrderedPizza>) : CartState
}