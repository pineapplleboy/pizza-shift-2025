package com.example.pizzashift.shared.data.repository

import com.example.pizzashift.shared.data.converter.toDomainModel
import com.example.pizzashift.shared.data.converter.toEntityModel
import com.example.pizzashift.shared.data.dao.PizzaDao
import com.example.pizzashift.shared.domain.repository.CartRepository
import com.example.pizzashift.shared.domain.model.OrderedPizza

class CartRepositoryImpl(
    private val pizzaDao: PizzaDao
): CartRepository {

    override fun getCart(): List<OrderedPizza> {
        return pizzaDao.getOrderedPizzas().map { it.toDomainModel() }
    }

    override fun addPizza(pizza: OrderedPizza) {
        pizzaDao.insertOrderedPizzas(pizza.toEntityModel())
    }
}