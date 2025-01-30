package com.example.pizzashift.shared.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ordered_pizzas",
    foreignKeys = [
        ForeignKey(
            entity = PizzaSizeEntity::class,
            parentColumns = ["id"],
            childColumns = ["sizeId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PizzaDoughEntity::class,
            parentColumns = ["id"],
            childColumns = ["doughId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class OrderedPizzaEntity(
    @PrimaryKey val id: String,
    val name: String,
    val sizeId: String,
    val doughId: String,
    val img: String
)