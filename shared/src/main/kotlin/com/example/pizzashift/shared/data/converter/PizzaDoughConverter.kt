package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.PizzaDoughDTO
import com.example.pizzashift.shared.domain.model.PizzaDough

fun PizzaDoughDTO.toDomainModel(): PizzaDough {

    return PizzaDough(
        name = this.name.toDomainModel(),
        price = this.price
    )
}

fun PizzaDough.toDTO(): PizzaDoughDTO {

    return PizzaDoughDTO(
        name = this.name.toDTO(),
        price = this.price
    )
}