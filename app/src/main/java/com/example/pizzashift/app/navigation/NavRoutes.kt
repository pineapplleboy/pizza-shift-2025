package com.example.pizzashift.app.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoutes(val route: String) {

    @Serializable
    data object Catalog : NavRoutes("catalog")

    @Serializable
    data object Pizza : NavRoutes("pizza_details/{pizza}") {
        fun createRoute(pizzaId: String) = "pizza_details/$pizzaId"
    }
}