package com.example.pizzashift.app.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.pizzashift.R
import com.example.pizzashift.domain.model.PizzaIngredient

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ToppingCard(
    topping: PizzaIngredient,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(4.dp, shape = RoundedCornerShape(16.dp))
            .background(
                color = colorResource(R.color.ghost_white),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        GlideImage(
            model = topping.img,
            contentDescription = topping.name.name,
            modifier = Modifier
                .height(88.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = topping.name.name,
                fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
                fontSize = 12.sp
            )

            Text(
                text = stringResource(R.string.cost, topping.cost.toString()),
                fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}