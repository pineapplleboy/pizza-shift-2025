package com.example.pizzashift.shared.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.data.entity.OrderedPizzaIngredientEntity
import com.example.pizzashift.shared.data.entity.PizzaDoughEntity
import com.example.pizzashift.shared.data.entity.PizzaSizeEntity

@Database(
    entities = [
        OrderedPizzaEntity::class,
        PizzaSizeEntity::class,
        PizzaDoughEntity::class,
        OrderedPizzaIngredientEntity::class
    ],
    version = 3
)
abstract class PizzaDatabase : RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao
}