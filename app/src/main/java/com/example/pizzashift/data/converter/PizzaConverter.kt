package com.example.pizzashift.data.converter

import com.example.pizzashift.data.AppConstants
import com.example.pizzashift.data.model.PizzaDTO
import com.example.pizzashift.domain.model.Pizza

fun PizzaDTO.toDomainModel(): Pizza {
    return Pizza(
        id = this.id,
        name = this.name,
        ingredients = this.ingredients.map { it.toDomainModel() },
        toppings = this.toppings.map { it.toDomainModel() },
        description = this.description,
        sizes = this.sizes.map { it.toDomainModel() },
        doughs = this.doughs.map { it.toDomainModel() },
        calories = this.calories,
        protein = this.protein,
        totalFat = this.totalFat,
        carbohydrates = this.carbohydrates,
        sodium = this.sodium,
        allergens = this.allergens,
        isVegetarian = this.isVegetarian,
        isGlutenFree = this.isGlutenFree,
        isNew = this.isNew,
        isHit = this.isHit,
        img = AppConstants.BASE_URL + this.img
    )
}