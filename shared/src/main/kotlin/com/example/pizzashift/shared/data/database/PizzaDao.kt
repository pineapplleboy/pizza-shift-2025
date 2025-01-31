package com.example.pizzashift.shared.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.domain.model.OrderedPizza

@Dao
interface PizzaDao {

    @Transaction
    @Query("SELECT * FROM ordered_pizzas")
    suspend fun getOrderedPizzas(): List<OrderedPizzaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderedPizzas(pizza: OrderedPizzaEntity)
}