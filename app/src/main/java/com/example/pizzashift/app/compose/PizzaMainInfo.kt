package com.example.pizzashift.app.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.R
import com.example.pizzashift.domain.model.Pizza

@Composable
fun PizzaMainInfo(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = pizza.name,
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = pizza.doughs[0].name.name, //пока не разбирался с тестом, не понял зачем нам список целый, в моём представлении здесь либо одно тесто, либо другое
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontSize = 14.sp
        )
        Text(
            text = pizza.ingredients.joinToString(separator = ", ") { it.name.name.lowercase() }
                .replaceFirstChar { it.uppercase() },
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontSize = 16.sp
        )
    }
}