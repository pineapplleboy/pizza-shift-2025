package com.example.pizzashift.shared.domain.repository

import com.example.pizzashift.shared.domain.model.OrderedPizza

interface CartRepository {

    suspend fun getCart(): List<OrderedPizza>

    suspend fun addPizza(pizza: OrderedPizza)
}