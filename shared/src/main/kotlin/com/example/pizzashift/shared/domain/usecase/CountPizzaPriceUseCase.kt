package com.example.pizzashift.shared.domain.usecase

import com.example.pizzashift.shared.domain.model.OrderedPizza

class CountPizzaPriceUseCase {

    operator fun invoke(pizza: OrderedPizza): Double {
        return pizza.size.price + pizza.toppings.sumOf { it.cost } + pizza.doughs.price
    }
}