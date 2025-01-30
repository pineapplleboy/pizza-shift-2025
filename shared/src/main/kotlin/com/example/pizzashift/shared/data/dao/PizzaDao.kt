package com.example.pizzashift.shared.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.data.entity.OrderedPizzaIngredientEntity
import com.example.pizzashift.shared.data.entity.PizzaDoughEntity
import com.example.pizzashift.shared.data.entity.PizzaSizeEntity
import com.example.pizzashift.shared.data.model.OrderedPizzaWithDetails

interface PizzaDao {

    @Transaction
    @Query("SELECT * FROM ordered_pizzas")
    fun getOrderedPizzas(): List<OrderedPizzaWithDetails>

    @Transaction
    fun insertOrderedPizzas(pizza: OrderedPizzaWithDetails) {
        insertPizza(pizza.pizza)
        insertSize(pizza.size)
        insertDough(pizza.dough)
        insertToppings(pizza.toppings)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPizza(pizza: OrderedPizzaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSize(size: PizzaSizeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDough(dough: PizzaDoughEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToppings(toppings: List<OrderedPizzaIngredientEntity>)
}