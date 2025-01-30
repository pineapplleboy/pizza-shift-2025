package com.example.pizzashift.shared.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.data.entity.OrderedPizzaIngredientEntity
import com.example.pizzashift.shared.data.entity.PizzaDoughEntity
import com.example.pizzashift.shared.data.entity.PizzaSizeEntity

data class OrderedPizzaWithDetails(
    @Embedded val pizza: OrderedPizzaEntity,

    @Relation(
        parentColumn = "orderId",
        entityColumn = "orderId"
    )
    val size: PizzaSizeEntity,

    @Relation(
        parentColumn = "orderId",
        entityColumn = "orderId"
    )
    val dough: PizzaDoughEntity,

    @Relation(
        parentColumn = "orderId",
        entityColumn = "pizzaId"
    )
    val toppings: List<OrderedPizzaIngredientEntity>
)