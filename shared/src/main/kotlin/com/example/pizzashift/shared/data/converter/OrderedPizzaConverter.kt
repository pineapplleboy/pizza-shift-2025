package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.entity.OrderedPizzaEntity
import com.example.pizzashift.shared.data.entity.OrderedPizzaIngredientEntity
import com.example.pizzashift.shared.data.entity.PizzaDoughEntity
import com.example.pizzashift.shared.data.entity.PizzaSizeEntity
import com.example.pizzashift.shared.data.model.OrderedPizzaDTO
import com.example.pizzashift.shared.data.model.OrderedPizzaIngredientDTO
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

    val orderId = UUID.randomUUID().toString()

    return OrderedPizzaWithDetails(
        pizza = OrderedPizzaEntity(
            orderId = orderId,
            id = this.id,
            name = this.name,
            img = this.img
        ),
        size = PizzaSizeEntity(
            name = this.size.name.name,
            price = this.size.price,
            orderId = orderId
        ),
        dough = PizzaDoughEntity(
            name = this.doughs.name.name,
            price = this.doughs.price,
            orderId = orderId
        ),
        toppings = this.toppings.map {

            OrderedPizzaIngredientEntity(
                name = it.name.name,
                cost = it.cost,
                pizzaId = orderId
            )
        }
    )
}

fun OrderedPizza.toDTO(): OrderedPizzaDTO {

    return OrderedPizzaDTO(
        id = this.id,
        name = this.name,
        toppings = this.toppings.map {
            OrderedPizzaIngredientDTO(
                name = it.name,
                cost = it.cost
            )
        },
        size = this.size.toDTO(),
        doughs = this.doughs.toDTO()
    )
}