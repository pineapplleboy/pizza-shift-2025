package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.PizzaSizeDTO
import com.example.pizzashift.shared.domain.model.PizzaSize

fun PizzaSizeDTO.toDomainModel(): PizzaSize {

    return PizzaSize(
        name = this.name.toDomainModel(),
        price = this.price
    )
}

fun PizzaSize.toDTO(): PizzaSizeDTO {

    return PizzaSizeDTO(
        name = this.name.toDTO(),
        price = this.price
    )
}