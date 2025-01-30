package com.example.pizzashift.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pizzashift.feature.cart.presentation.CartViewModel
import com.example.pizzashift.feature.cart.ui.CartScreen
import com.example.pizzashift.feature.pizza_catalog.ui.PizzaCatalogScreen
import com.example.pizzashift.feature.pizza_details.ui.PizzaDetailsScreen
import com.example.pizzashift.feature.pizza_catalog.presentation.PizzaCatalogViewModel
import com.example.pizzashift.feature.pizza_details.presentation.PizzaDetailsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainNavHost(
    navController: NavHostController,
    selectedScreen: String = NavRoutes.Catalog.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = selectedScreen,
        modifier = modifier
    ) {
        composable(NavRoutes.Catalog.route) {
            val viewModel = koinViewModel<PizzaCatalogViewModel>()
            PizzaCatalogScreen(
                viewModel = viewModel,
                onPizzaSelected = { navController.navigate(NavRoutes.Pizza.createRoute(it)) }
            )
        }

        composable(
            route = NavRoutes.Pizza.route,
            arguments = listOf(navArgument("pizza") { type = NavType.StringType })
        ) {
            val pizzaId = it.arguments?.getString("pizza")
            val viewModel = koinViewModel<PizzaDetailsViewModel>(parameters = { parametersOf(pizzaId) })
            PizzaDetailsScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(NavRoutes.Cart.route) {
            val viewModel = koinViewModel<CartViewModel>()
            CartScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}
