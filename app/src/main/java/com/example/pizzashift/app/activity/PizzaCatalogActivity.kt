package com.example.pizzashift.app.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.pizzashift.app.compose.PizzaCatalogScreen
import com.example.pizzashift.app.viewmodel.PizzaCatalogViewModel
import com.example.pizzashift.ui.theme.PizzaShiftTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class PizzaCatalogActivity : ComponentActivity() {

    private val vm by viewModel<PizzaCatalogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PizzaShiftTheme {

                val pizzas by vm.pizzas.observeAsState()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    PizzaCatalogScreen(
                        pizzas = pizzas ?: listOf(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}