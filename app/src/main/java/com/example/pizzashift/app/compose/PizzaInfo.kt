package com.example.pizzashift.app.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pizzashift.R
import com.example.pizzashift.domain.model.Pizza

@Composable
fun PizzaInfo(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = pizza.name,
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        Text(
            text = pizza.description,
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontSize = 14.sp
        )
    }
}