package com.example.pizzashift.data.converter

import com.example.pizzashift.data.model.PizzaSizeDTO
import com.example.pizzashift.domain.model.PizzaSize

fun PizzaSizeDTO.toDomainModel(): PizzaSize {

    return PizzaSize(
        name = this.name.toDomainModel(),
        price = this.price
    )
}