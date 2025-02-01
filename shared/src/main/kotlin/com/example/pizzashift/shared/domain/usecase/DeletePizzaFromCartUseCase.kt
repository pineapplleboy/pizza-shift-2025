package com.example.pizzashift.shared.domain.usecase

import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.repository.CartRepository

class DeletePizzaFromCartUseCase(
    private val repository: CartRepository
) {

    suspend operator fun invoke(pizza: OrderedPizza) {
        repository.deletePizza(pizza)
    }
}