package com.example.pizzashift.shared.data.model

data class PizzaIngredientDTO(
    val name: IngredientTypeDTO,
    val cost: Double,
    val img: String
)