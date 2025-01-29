package com.example.pizzashift.shared.data.model

data class PizzaDTO(
    val id: String,
    val name: String,
    val ingredients: List<PizzaIngredientDTO>,
    val toppings: List<PizzaIngredientDTO>,
    val description: String,
    val sizes: List<PizzaSizeDTO>,
    val doughs: List<PizzaDoughDTO>,
    val calories: Int,
    val protein: String,
    val totalFat: String,
    val carbohydrates: String,
    val sodium: String,
    val allergens: List<String>,
    val isVegetarian: Boolean,
    val isGlutenFree: Boolean,
    val isNew: Boolean,
    val isHit: Boolean,
    val img: String
)