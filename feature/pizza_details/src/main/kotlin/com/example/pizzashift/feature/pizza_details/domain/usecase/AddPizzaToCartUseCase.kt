package com.example.pizzashift.feature.pizza_details.domain.usecase

import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.repository.CartRepository

class AddPizzaToCartUseCase(
    private val repository: CartRepository
) {

    suspend operator fun invoke(pizza: OrderedPizza) {
        repository.addPizza(pizza)
    }
}