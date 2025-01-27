package com.example.pizzashift.data.converter

import com.example.pizzashift.data.model.DoughTypeDTO
import com.example.pizzashift.domain.model.DoughType

fun DoughTypeDTO.toDomainModel(): DoughType {

    return DoughType.valueOf(this.name)
}