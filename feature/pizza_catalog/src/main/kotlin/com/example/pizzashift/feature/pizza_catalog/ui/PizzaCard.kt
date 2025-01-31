package com.example.pizzashift.feature.pizza_catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.Pizza

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PizzaCard(
    pizza: Pizza,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
            .background(
                color = colorResource(R.color.ghost_white),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                onClick(pizza.id)
            }
    ) {
        GlideImage(
            model = pizza.img,
            contentDescription = "Pizza Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        PizzaInfo(
            pizza = pizza,
            modifier = Modifier.padding(
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
        )
    }
}