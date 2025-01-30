package com.example.pizzashift.shared.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pizza_doughs")
class PizzaDoughEntity (
    @PrimaryKey val id: String,
    val name: String,
    val price: Double
)