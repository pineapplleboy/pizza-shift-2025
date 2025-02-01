package com.example.pizzashift.shared.domain.model

import com.example.pizzashift.shared.R

enum class IngredientType {
    PINEAPPLE, MOZZARELLA, PEPERONI, GREEN_PEPPER, MUSHROOMS, BASIL, CHEDDAR,
    PARMESAN, FETA, HAM, PICKLE, TOMATO, BACON, ONION, CHILE, SHRIMPS,
    CHICKEN_FILLET, MEATBALLS
}

fun IngredientType.getLocalizedName(): Int {
    val resId = when (this) {
        IngredientType.PINEAPPLE -> R.string.ingredient_pineapple
        IngredientType.MOZZARELLA -> R.string.ingredient_mozzarella
        IngredientType.PEPERONI -> R.string.ingredient_peperoni
        IngredientType.GREEN_PEPPER -> R.string.ingredient_green_pepper
        IngredientType.MUSHROOMS -> R.string.ingredient_mushrooms
        IngredientType.BASIL -> R.string.ingredient_basil
        IngredientType.CHEDDAR -> R.string.ingredient_cheddar
        IngredientType.PARMESAN -> R.string.ingredient_parmesan
        IngredientType.FETA -> R.string.ingredient_feta
        IngredientType.HAM -> R.string.ingredient_ham
        IngredientType.PICKLE -> R.string.ingredient_pickle
        IngredientType.TOMATO -> R.string.ingredient_tomato
        IngredientType.BACON -> R.string.ingredient_bacon
        IngredientType.ONION -> R.string.ingredient_onion
        IngredientType.CHILE -> R.string.ingredient_chile
        IngredientType.SHRIMPS -> R.string.ingredient_shrimps
        IngredientType.CHICKEN_FILLET -> R.string.ingredient_chicken_fillet
        IngredientType.MEATBALLS -> R.string.ingredient_meatballs
    }
    return resId
}