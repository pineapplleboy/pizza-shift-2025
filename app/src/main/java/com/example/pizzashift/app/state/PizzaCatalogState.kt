package com.example.pizzashift.app.state

import com.example.pizzashift.domain.model.Pizza

sealed interface PizzaCatalogState {

    data object Initial : PizzaCatalogState

    data object Loading : PizzaCatalogState

    data class Failure(val message: String?): PizzaCatalogState

    data class Content(val pizzas: List<Pizza>): PizzaCatalogState
}