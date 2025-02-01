package com.example.pizzashift.shared.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.domain.model.OrderedPizzaIngredient
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.PizzaSize

@Dao
interface PizzaDao {

    @Transaction
    @Query("SELECT * FROM ordered_pizzas")
    suspend fun getOrderedPizzas(): List<OrderedPizzaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderedPizzas(pizza: OrderedPizzaEntity)

    @Query("DELETE FROM ordered_pizzas")
    suspend fun deleteOrderedPizzas()

    @Query(
        """
    DELETE FROM ordered_pizzas 
    WHERE id = :id 
    AND name = :name 
    AND img = :img 
    AND ingredients = :ingredients 
    AND size = :size 
    AND doughs = :doughs
"""
    )
    suspend fun deletePizza(
        id: String,
        name: String,
        img: String,
        ingredients: List<OrderedPizzaIngredient>,
        size: PizzaSize,
        doughs: PizzaDough
    )
}