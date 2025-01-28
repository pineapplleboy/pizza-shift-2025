package com.example.pizzashift.data.converter

import com.example.pizzashift.data.model.IngredientTypeDTO
import com.example.pizzashift.domain.model.IngredientType

fun IngredientTypeDTO.toDomainModel(): IngredientType = IngredientType.valueOf(this.name)