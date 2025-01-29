package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.DataConstants
import com.example.pizzashift.shared.data.model.PizzaIngredientDTO
import com.example.pizzashift.shared.domain.model.PizzaIngredient

fun PizzaIngredientDTO.toDomainModel(): PizzaIngredient {
    return PizzaIngredient(
        name = this.name.toDomainModel(),
        cost = this.cost,
        img = DataConstants.BASE_URL + this.img
    )
}