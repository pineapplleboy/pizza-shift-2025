package com.example.pizzashift.domain.usecase

import com.example.pizzashift.domain.model.Pizza
import com.example.pizzashift.domain.repository.PizzaRepository

class GetPizzaCatalogUseCase(
    private val repository: PizzaRepository
) {

    suspend operator fun invoke(): List<Pizza> {
        return repository.getPizzaCatalog()
    }
}