package com.example.pizzashift.data.converter

import com.example.pizzashift.data.model.SizeTypeDTO
import com.example.pizzashift.domain.model.SizeType

fun SizeTypeDTO.toDomainModel(): SizeType {

    return SizeType.valueOf(this.name)
}