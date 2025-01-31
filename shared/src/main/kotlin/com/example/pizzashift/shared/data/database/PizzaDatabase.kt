package com.example.pizzashift.shared.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pizzashift.shared.data.converter.PizzaDatabaseConverter
import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity

@Database(
    entities = [
        OrderedPizzaEntity::class
    ],
    version = 4
)
@TypeConverters(PizzaDatabaseConverter::class)
abstract class PizzaDatabase : RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao
}