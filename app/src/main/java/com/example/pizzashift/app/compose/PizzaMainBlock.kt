package com.example.pizzashift.app.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizzashift.domain.model.Pizza

@Composable
fun PizzaMainBlock(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        PizzaMainInfo(
            pizza = pizza
        )

        PizzaSizeBlock()

        PizzaToppingsBlock(
            toppings = pizza.toppings
        )
    }
}