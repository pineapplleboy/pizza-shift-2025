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
        insertPizza(pizza.pizza)
        insertSize(pizza.size)
        insertDough(pizza.dough)
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


    @Query("DELETE FROM ordered_pizzas")
    fun deleteAllOrderedPizzas()

    @Query("DELETE FROM pizza_sizes")
    fun deleteAllPizzaSizes()

    @Query("DELETE FROM pizza_doughs")
    fun deleteAllPizzaDoughs()

    @Query("DELETE FROM ordered_pizza_ingredients")
    fun deleteAllPizzaIngredients()

    @Transaction
    suspend fun clearDatabase() {
        deleteAllOrderedPizzas()
        deleteAllPizzaSizes()
        deleteAllPizzaDoughs()
    }

    @Query("DELETE FROM ordered_pizzas WHERE orderId = :orderId")
    fun deletePizzaById(orderId: String)
}