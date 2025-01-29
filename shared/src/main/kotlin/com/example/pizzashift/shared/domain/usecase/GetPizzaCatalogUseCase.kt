package com.example.pizzashift.shared.domain.usecase

import com.example.pizzashift.shared.domain.model.Pizza
import com.example.pizzashift.shared.domain.repository.PizzaRepository

class GetPizzaCatalogUseCase(
    private val repository: PizzaRepository
) {

    suspend operator fun invoke(): List<Pizza> {
        return repository.getPizzaCatalog()
    }
}