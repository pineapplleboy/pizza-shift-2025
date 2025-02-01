package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.data.model.OrderedPizzaDTO
import com.example.pizzashift.shared.data.model.OrderedPizzaIngredientDTO
import com.example.pizzashift.shared.domain.model.OrderedPizza

fun OrderedPizza.toEntityModel(): OrderedPizzaEntity {

    return OrderedPizzaEntity(
        id = this.id,
        name = this.name,
        img = this.img,
        ingredients = this.toppings,
        size = this.size,
        doughs = this.doughs
    )
}

fun OrderedPizzaEntity.toDomainModel(): OrderedPizza {

    return OrderedPizza(
        id = this.id,
        name = this.name,
        img = this.img,
        toppings = this.ingredients,
        size = this.size,
        doughs = this.doughs
    )
}

fun OrderedPizza.toDTO(): OrderedPizzaDTO {

    return OrderedPizzaDTO(
        id = this.id,
        name = this.name,
        toppings = this.toppings.map {
            OrderedPizzaIngredientDTO(
                name = it.name,
                cost = it.cost
            )
        },
        size = this.size.toDTO(),
        doughs = this.doughs.toDTO()
    )
}