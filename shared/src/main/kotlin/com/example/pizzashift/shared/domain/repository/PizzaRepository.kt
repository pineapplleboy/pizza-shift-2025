package com.example.pizzashift.shared.domain.repository

import com.example.pizzashift.shared.domain.model.Pizza

interface PizzaRepository {

    suspend fun getPizzaCatalog(): List<Pizza>
}