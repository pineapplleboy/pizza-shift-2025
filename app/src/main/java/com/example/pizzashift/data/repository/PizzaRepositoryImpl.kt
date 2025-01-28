package com.example.pizzashift.data.repository

import com.example.pizzashift.data.converter.toDomainModel
import com.example.pizzashift.data.network.PizzaApi
import com.example.pizzashift.domain.model.Pizza
import com.example.pizzashift.domain.repository.PizzaRepository

class PizzaRepositoryImpl(
    private val api: PizzaApi
): PizzaRepository {

    override suspend fun getPizzaCatalog(): List<Pizza> {
        return api.getPizzaCatalog().catalog.map { it.toDomainModel() }
    }
}