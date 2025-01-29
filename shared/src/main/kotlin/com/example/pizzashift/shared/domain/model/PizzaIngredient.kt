package com.example.pizzashift.shared.domain.model

data class PizzaIngredient(
    val name: IngredientType,
    val cost: Double,
    val img: String
)