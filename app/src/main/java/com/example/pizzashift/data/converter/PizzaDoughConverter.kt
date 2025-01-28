package com.example.pizzashift.data.converter

import com.example.pizzashift.data.model.PizzaDoughDTO
import com.example.pizzashift.domain.model.PizzaDough

fun PizzaDoughDTO.toDomainModel(): PizzaDough {

    return PizzaDough(
        name = this.name.toDomainModel(),
        price = this.price
    )
}