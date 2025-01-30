package com.example.pizzashift.shared.data.model

import com.example.pizzashift.shared.domain.model.IngredientType

data class OrderedPizzaIngredientDTO(
    val name: IngredientType,
    val cost: Double
)