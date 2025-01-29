package com.example.pizzashift.shared.domain.model

data class OrderedPizzaIngredient(
    val name: IngredientType,
    val cost: Int
)