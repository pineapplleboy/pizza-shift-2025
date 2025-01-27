package com.example.pizzashift.domain.model

data class PizzaIngredient(
    val name: IngredientType,
    val cost: Double,
    val img: String
)