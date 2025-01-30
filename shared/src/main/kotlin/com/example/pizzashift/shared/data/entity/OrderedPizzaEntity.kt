package com.example.pizzashift.shared.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ordered_pizzas"
)
data class OrderedPizzaEntity(
    @PrimaryKey val orderId: String,
    val id: String,
    val name: String,
    val sizeId: String,
    val doughId: String,
    val img: String
)