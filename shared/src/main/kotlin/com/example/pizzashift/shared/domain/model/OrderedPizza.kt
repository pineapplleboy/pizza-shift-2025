package com.example.pizzashift.shared.domain.model

data class OrderedPizza(
    val id: String,
    val name: String,
    val toppings: List<OrderedPizzaIngredient>,
    val size: PizzaSize,
    val doughs: PizzaDough,
    val img: String
)