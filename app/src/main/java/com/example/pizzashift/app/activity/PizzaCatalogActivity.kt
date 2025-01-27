package com.example.pizzashift.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.pizzashift.app.compose.PizzaCatalogScreen
import com.example.pizzashift.ui.theme.PizzaShiftTheme

class PizzaCatalogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaShiftTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    PizzaCatalogScreen(
                        pizzas = listOf(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}