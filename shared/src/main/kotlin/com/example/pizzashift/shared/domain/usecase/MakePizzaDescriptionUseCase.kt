package com.example.pizzashift.shared.domain.usecase

import com.example.pizzashift.shared.domain.model.OrderedPizza

class MakePizzaDescriptionUseCase {

    operator fun invoke(pizza: OrderedPizza): String {
        return "${pizza.name}, ${pizza.size.name}, ${pizza.doughs.name}" +
                (if (pizza.toppings.isNotEmpty())
                    "+ ${pizza.toppings.joinToString(", ") { it.name.name.lowercase() }}"
                else "")
    }
}