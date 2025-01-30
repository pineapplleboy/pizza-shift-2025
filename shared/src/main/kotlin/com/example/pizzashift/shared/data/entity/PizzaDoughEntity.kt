package com.example.pizzashift.shared.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pizza_doughs",
    foreignKeys = [
        ForeignKey(
            entity = OrderedPizzaEntity::class,
            parentColumns = ["orderId"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class PizzaDoughEntity (
    @PrimaryKey val id: String,
    val name: String,
    val price: Double,
    val orderId: String
)