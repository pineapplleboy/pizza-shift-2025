package com.example.pizzashift.feature.orders.presentation

import com.example.pizzashift.shared.domain.model.PizzaOrder

sealed interface OrdersState {

    data object Loading : OrdersState

    data class Content(val orders: List<PizzaOrder>) : OrdersState

    data object Initial : OrdersState

    data class Failure(val message: String) : OrdersState
}