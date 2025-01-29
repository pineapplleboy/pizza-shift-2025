package com.example.pizzashift.feature.cart.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.OrderedPizza

@Composable
fun OrderedPizzaSetting(
    pizza: OrderedPizza,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            PizzaAmountSettings()

            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(com.example.pizzashift.feature.cart.R.string.change_ordered_pizza_button),
                    color = Color.Black
                )
            }
        }

        Text(
            text = stringResource(R.string.cost, pizza.size.price + pizza.toppings.sumOf { it.cost } + pizza.doughs.price),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontWeight = FontWeight.Bold
        )
    }
}