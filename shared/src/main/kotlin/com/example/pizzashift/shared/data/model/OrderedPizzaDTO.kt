package com.example.pizzashift.shared.data.model

data class OrderedPizzaDTO(
    val id: String,
    val name: String,
    val toppings: List<OrderedPizzaIngredientDTO>,
    val size: PizzaSizeDTO,
    val doughs: PizzaDoughDTO
)