package com.example.pizzashift.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes(val route: String) {

    @Serializable
    data object Catalog : NavRoutes("catalog")

    @Serializable
    data object Cart : NavRoutes("cart")

    @Serializable
    data object Checkout : NavRoutes("checkout")

    @Serializable
    data object Authorization : NavRoutes("authorization")

    @Serializable
    data object Orders : NavRoutes("orders")

    @Serializable
    data object Pizza : NavRoutes("pizza_details/{pizza}") {
        fun createRoute(pizzaId: String) = "pizza_details/$pizzaId"
    }
}