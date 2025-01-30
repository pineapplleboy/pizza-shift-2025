package com.example.pizzashift.shared.domain.repository

import com.example.pizzashift.shared.domain.model.OrderedPizza

interface CartRepository {

    fun getCart(): List<OrderedPizza>

    fun addPizza(pizza: OrderedPizza)
}