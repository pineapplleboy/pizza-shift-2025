package com.example.pizzashift.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val items = listOf("catalog", "orders", "cart", "profile")
    val selectedScreen = remember { mutableStateOf(NavRoutes.Catalog.route) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                contentColor = Color.Black
            ) {
                items.forEachIndexed { _, label ->
                    NavigationBarItem(
                        icon = {
                            when(label) {
                                "catalog" -> Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = label
                                )
                                "orders" -> Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = label
                                )
                                "cart" -> Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = label
                                )
                                "profile" -> Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = label
                                )
                            }
                        },
                        label = { Text(label) },
                        selected = selectedScreen.value == label,
                        onClick = {
                            selectedScreen.value = label
                            navController.navigate(label) {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        MainNavHost(
            navController = navController,
            selectedScreen = selectedScreen.value,
            modifier = modifier.padding(paddingValues)
        )
    }
}
