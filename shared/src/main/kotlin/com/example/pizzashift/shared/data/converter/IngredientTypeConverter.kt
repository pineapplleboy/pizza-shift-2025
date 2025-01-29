package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.IngredientTypeDTO
import com.example.pizzashift.shared.domain.model.IngredientType

fun IngredientTypeDTO.toDomainModel(): IngredientType = IngredientType.valueOf(this.name)