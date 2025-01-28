package com.example.pizzashift.app.state

import com.example.pizzashift.domain.model.Pizza

sealed interface PizzaDetailsState {

    data object Initial : PizzaDetailsState

    data object Loading : PizzaDetailsState

    data class Failure(val message: String?): PizzaDetailsState

    data class Content(val pizza: Pizza): PizzaDetailsState
}