package com.example.pizzashift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pizzashift.navigation.BottomNavigationBarItems
import com.example.pizzashift.navigation.MainNavHost
import com.example.pizzashift.navigation.NavRoutes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    background = Color.White,
                    surface = Color.White
                )
            ) {
                val navController = rememberNavController()
                val currentBackStackEntry = navController.currentBackStackEntryAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (shouldShowBottomBar(currentBackStackEntry.value?.destination?.route)) {
                            BottomNavigationBarItems(navController)
                        }
                    }
                ) { innerPadding ->

                    MainNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun shouldShowBottomBar(route: String?): Boolean {
        val hiddenBottomBarRoutes = listOf(NavRoutes.Checkout.route, NavRoutes.Authorization.route)
        return route !in hiddenBottomBarRoutes
    }
}