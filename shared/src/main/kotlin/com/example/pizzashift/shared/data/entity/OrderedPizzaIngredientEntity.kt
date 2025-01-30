package com.example.pizzashift.shared.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "ordered_pizza_ingredients",
    foreignKeys = [ForeignKey(
        entity = OrderedPizzaEntity::class,
        parentColumns = ["id"],
        childColumns = ["pizzaId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class OrderedPizzaIngredientEntity(
    val name: String,
    val cost: Double,
    val pizzaId: String
)