package com.example.pizzashift.app.compose

import androidx.compose.foundation.background
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
import com.example.pizzashift.R
import com.example.pizzashift.domain.model.Pizza

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PizzaCard(
    pizza: Pizza,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
            .background(
                color = colorResource(R.color.ghost_white),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {
        GlideImage(
            model = pizza.img,
            contentDescription = "Pizza Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        PizzaInfo(pizza = pizza)
    }
}