package com.example.pizzashift.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pizzashift.app.screen.PizzaCatalogScreen
import com.example.pizzashift.app.screen.PizzaDetailsScreen
import com.example.pizzashift.app.viewmodel.PizzaCatalogViewModel
import com.example.pizzashift.app.viewmodel.PizzaDetailsViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Catalog,
        modifier = modifier
    ) {
        composable<NavRoutes.Catalog> {

            val vm = koinViewModel<PizzaCatalogViewModel>()

            PizzaCatalogScreen(
                vm = vm,
                onPizzaSelected = { navController.navigate(NavRoutes.Pizza.createRoute(it)) },
                modifier = modifier
            )
        }

        composable(
            route = NavRoutes.Pizza.route,
            arguments = listOf(navArgument("pizza") { type = NavType.StringType })
        ) { backStackEntry ->

            val pizzaId = backStackEntry.arguments?.getString("pizza")
            val vm = koinViewModel<PizzaDetailsViewModel>(parameters = { parametersOf(pizzaId) })

            PizzaDetailsScreen(
                vm = vm,
                modifier = modifier
            )
        }
    }
}