package com.example.pizzashift.shared.data.repository

import com.example.pizzashift.shared.data.converter.toDomainModel
import com.example.pizzashift.shared.data.converter.toEntityModel
import com.example.pizzashift.shared.data.database.PizzaDao
import com.example.pizzashift.shared.domain.repository.CartRepository
import com.example.pizzashift.shared.domain.model.OrderedPizza

class CartRepositoryImpl(
    private val pizzaDao: PizzaDao
): CartRepository {

    override suspend fun getCart(): List<OrderedPizza> {
        return pizzaDao.getOrderedPizzas().map { it.toDomainModel() }
    }

    override suspend fun addPizza(pizza: OrderedPizza) {
        pizzaDao.insertOrderedPizzas(pizza.toEntityModel())
    }
}