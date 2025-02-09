package com.example.pizzashift.shared.data.repository

import com.example.pizzashift.shared.data.converter.toDomainModel
import com.example.pizzashift.shared.data.network.PizzaApi
import com.example.pizzashift.shared.domain.model.Pizza
import com.example.pizzashift.shared.domain.repository.PizzaRepository

class PizzaRepositoryImpl(
    private val api: PizzaApi
): PizzaRepository {

    override suspend fun getPizzaCatalog(): List<Pizza> {
        return api.getPizzaCatalog().catalog.map { it.toDomainModel() }
    }
}