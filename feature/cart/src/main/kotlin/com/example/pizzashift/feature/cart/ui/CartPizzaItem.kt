package com.example.pizzashift.feature.cart.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.model.getLocalizedName

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartPizzaItem(
    pizza: OrderedPizza,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val toppings = pizza.toppings.map { stringResource(it.name.getLocalizedName()) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GlideImage(
            model = pizza.img,
            contentDescription = pizza.name,
            modifier = Modifier
                .width(66.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = pizza.name,
                fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                text = stringResource(
                    com.example.pizzashift.feature.cart.R.string.cart_pizza_info,
                    pizza.size.name,
                    pizza.doughs.name,
                    toppings.joinToString(separator = ", ") { it.lowercase() }),
                fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
                fontSize = 12.sp
            )

            OrderedPizzaSetting(
                pizza = pizza,
                onDelete = onDelete
            )
        }
    }
}