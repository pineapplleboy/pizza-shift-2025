package com.example.pizzashift.shared.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.data.entity.OrderedPizzaIngredientEntity
import com.example.pizzashift.shared.data.entity.PizzaDoughEntity
import com.example.pizzashift.shared.data.entity.PizzaSizeEntity
import com.example.pizzashift.shared.data.model.OrderedPizzaWithDetails

@Dao
interface PizzaDao {

    @Transaction
    @Query("SELECT * FROM ordered_pizzas")
    suspend fun getOrderedPizzas(): List<OrderedPizzaWithDetails>

    @Transaction
    suspend fun insertOrderedPizzas(pizza: OrderedPizzaWithDetails) {
        insertSize(pizza.size)
        insertDough(pizza.dough)
        insertPizza(pizza.pizza)
        insertToppings(pizza.toppings)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizza(pizza: OrderedPizzaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSize(size: PizzaSizeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDough(dough: PizzaDoughEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToppings(toppings: List<OrderedPizzaIngredientEntity>)
}