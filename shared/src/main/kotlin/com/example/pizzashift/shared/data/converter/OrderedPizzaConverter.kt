package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.data.entity.OrderedPizzaIngredientEntity
import com.example.pizzashift.shared.data.entity.PizzaDoughEntity
import com.example.pizzashift.shared.data.entity.PizzaSizeEntity
import com.example.pizzashift.shared.data.model.OrderedPizzaWithDetails
import com.example.pizzashift.shared.domain.model.DoughType
import com.example.pizzashift.shared.domain.model.IngredientType
import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.model.OrderedPizzaIngredient
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.PizzaSize
import com.example.pizzashift.shared.domain.model.SizeType
import java.util.UUID

fun OrderedPizzaWithDetails.toDomainModel(): OrderedPizza {

    return OrderedPizza(
        id = this.pizza.id,
        name = this.pizza.name,
        toppings = this.toppings.map {
            OrderedPizzaIngredient(
                name = IngredientType.valueOf(it.name),
                cost = it.cost
            )
        },
        size = PizzaSize(
            name = SizeType.valueOf(this.size.name),
            price = this.size.price
        ),
        doughs = PizzaDough(
            name = DoughType.valueOf(this.dough.name),
            price = this.dough.price
        ),
        img = this.pizza.img
    )
}

fun OrderedPizza.toEntityModel(): OrderedPizzaWithDetails {

    val sizeId = UUID.randomUUID().toString()
    val doughId = UUID.randomUUID().toString()

    return OrderedPizzaWithDetails(
        pizza = OrderedPizzaEntity(
            id = this.id,
            name = this.name,
            sizeId = sizeId,
            doughId = doughId,
            img = this.img
        ),
        size = PizzaSizeEntity(
            id = sizeId,
            name = this.size.name.name,
            price = this.size.price
        ),
        dough = PizzaDoughEntity(
            id = doughId,
            name = this.doughs.name.name,
            price = this.doughs.price
        ),
        toppings = this.toppings.map {

            OrderedPizzaIngredientEntity(
                name = it.name.name,
                cost = it.cost,
                pizzaId = this.id
            )
        }
    )
}