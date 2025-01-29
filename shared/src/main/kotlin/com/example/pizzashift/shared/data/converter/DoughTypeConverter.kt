package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.DoughTypeDTO
import com.example.pizzashift.shared.domain.model.DoughType

fun DoughTypeDTO.toDomainModel(): DoughType = DoughType.valueOf(this.name)