package com.example.pizzashift.shared.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.pizzashift.shared.data.converter.PizzaDatabaseConverter
import com.example.pizzashift.shared.domain.model.OrderedPizzaIngredient
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.PizzaSize

@Entity(
    tableName = "ordered_pizzas"
)
@TypeConverters(PizzaDatabaseConverter::class)
data class OrderedPizzaEntity(
    @PrimaryKey(autoGenerate = true) val orderId: Long = 0,
    val id: String,
    val name: String,
    val img: String,
    val ingredients: List<OrderedPizzaIngredient>,
    val size: PizzaSize,
    val doughs: PizzaDough
)