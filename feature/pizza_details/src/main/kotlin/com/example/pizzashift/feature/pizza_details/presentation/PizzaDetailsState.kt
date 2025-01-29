package com.example.pizzashift.feature.pizza_details.presentation

import com.example.pizzashift.shared.domain.model.Pizza

sealed interface PizzaDetailsState {

    data object Initial : PizzaDetailsState

    data object Loading : PizzaDetailsState

    data class Failure(val message: String?): PizzaDetailsState

    data class Content(val pizza: Pizza): PizzaDetailsState
}