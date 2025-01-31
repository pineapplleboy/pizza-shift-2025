package com.example.pizzashift.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBarItems(navController: NavHostController) {
    val items = listOf("catalog", "orders", "cart", "profile")
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black
    ) {
        items.forEach { label ->
            NavigationBarItem(
                icon = {
                    when (label) {
                        "catalog" -> Icon(Icons.Default.Home, contentDescription = label)
                        "orders" -> Icon(Icons.Default.CheckCircle, contentDescription = label)
                        "cart" -> Icon(Icons.Default.ShoppingCart, contentDescription = label)
                        "profile" -> Icon(Icons.Default.Person, contentDescription = label)
                    }
                },
                label = { Text(label) },
                selected = currentRoute == label,
                onClick = {
                    navController.navigate(label) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
