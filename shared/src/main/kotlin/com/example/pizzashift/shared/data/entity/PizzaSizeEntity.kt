package com.example.pizzashift.shared.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza_sizes")
class PizzaSizeEntity (
    @PrimaryKey val id: String,
    val name: String,
    val price: Double
)