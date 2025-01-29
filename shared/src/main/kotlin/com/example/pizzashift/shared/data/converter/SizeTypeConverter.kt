package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.SizeTypeDTO
import com.example.pizzashift.shared.domain.model.SizeType

fun SizeTypeDTO.toDomainModel(): SizeType = SizeType.valueOf(this.name)