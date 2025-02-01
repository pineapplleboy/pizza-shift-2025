package com.example.pizzashift.feature.pizza_details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.SizeType

@Composable
fun PizzaSizeButton(
    size: SizeType,
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    onClick: () -> Unit
) {
    Text(
        text = when (size) {
            SizeType.SMALL  -> stringResource(R.string.pizza_size_small)
            SizeType.MEDIUM -> stringResource(R.string.pizza_size_medium)
            SizeType.LARGE  -> stringResource(R.string.pizza_size_large)
        },
        fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
        fontSize = 14.sp,
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = if (isActive) Color.White else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    )
}