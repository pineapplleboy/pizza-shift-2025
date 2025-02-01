package com.example.pizzashift.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun OrderInfoSegment(
    name: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            fontFamily = FontFamily(Font(com.example.pizzashift.shared.R.font.montserrat_font_family)),
            fontSize = 12.sp
        )
        Text(
            text = content,
            fontFamily = FontFamily(Font(com.example.pizzashift.shared.R.font.montserrat_font_family)),
            fontSize = 16.sp
        )
    }
}