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
import com.example.pizzashift.shared.domain.model.PizzaSize
import com.example.pizzashift.shared.domain.model.SizeType

@Composable
fun PizzaSizeBlock(
    currentSize: PizzaSize,
    modifier: Modifier = Modifier,
    onSizeChanged: (SizeType) -> Unit
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
            isActive = SizeType.SMALL == currentSize.name,
            modifier = Modifier.weight(1f)
        ) {
            onSizeChanged(SizeType.SMALL)
        }

        PizzaSizeButton(
            size = SizeType.MEDIUM,
            isActive = SizeType.MEDIUM == currentSize.name,
            modifier = Modifier.weight(1f)
        ) {
            onSizeChanged(SizeType.MEDIUM)
        }

        PizzaSizeButton(
            size = SizeType.LARGE,
            isActive = SizeType.LARGE == currentSize.name,
            modifier = Modifier.weight(1f)
        ) {
            onSizeChanged(SizeType.LARGE)
        }
    }
}