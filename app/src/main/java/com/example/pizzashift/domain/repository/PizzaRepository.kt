package com.example.pizzashift.domain.repository

import com.example.pizzashift.domain.model.Pizza

interface PizzaRepository {

    suspend fun getPizzaCatalog(): List<Pizza>
}