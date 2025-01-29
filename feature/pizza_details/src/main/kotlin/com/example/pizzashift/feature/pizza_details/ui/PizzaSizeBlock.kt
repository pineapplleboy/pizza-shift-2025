package com.example.pizzashift.feature.pizza_details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.SizeType

@Composable
fun PizzaSizeBlock(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(
                color = colorResource(R.color.light_gray),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(2.dp)
    ) {
        PizzaSizeButton(
            size = SizeType.SMALL,
            isActive = true,
            modifier = Modifier.weight(1f)
        )
        PizzaSizeButton(
            size = SizeType.MEDIUM,
            modifier = Modifier.weight(1f)
        )
        PizzaSizeButton(
            size = SizeType.LARGE,
            modifier = Modifier.weight(1f)
        )
    }
}