package com.example.pizzashift.feature.pizza_details.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.DoughType
import com.example.pizzashift.shared.domain.model.Pizza
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.getLocalizedName

@Composable
fun PizzaMainInfo(
    pizza: Pizza,
    dough: PizzaDough,
    onDoughChanged: (PizzaDough) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val ingredients =
            pizza.ingredients.map { stringResource(it.name.getLocalizedName()).lowercase() }

        Text(
            text = pizza.name,
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = if (dough.name == DoughType.THIN) stringResource(com.example.pizzashift.feature.pizza_details.R.string.thin_dough) else stringResource(
                com.example.pizzashift.feature.pizza_details.R.string.thick_dough
            ),
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                if (dough == pizza.doughs[0])
                    onDoughChanged(pizza.doughs[1])
                else
                    onDoughChanged(pizza.doughs[0])
            }
        )
        Text(
            text = ingredients.joinToString(separator = ", ") { it.lowercase() }
                .replaceFirstChar { it.uppercase() },
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontSize = 16.sp
        )
    }
}