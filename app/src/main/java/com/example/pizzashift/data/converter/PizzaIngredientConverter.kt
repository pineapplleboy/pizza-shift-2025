package com.example.pizzashift.data.converter

import com.example.pizzashift.data.model.PizzaIngredientDTO
import com.example.pizzashift.domain.model.PizzaIngredient

fun PizzaIngredientDTO.toDomainModel(): PizzaIngredient {
    return PizzaIngredient(
        name = this.name.toDomainModel(),
        cost = this.cost,
        img = this.img
    )
}