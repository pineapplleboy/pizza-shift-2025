package com.example.pizzashift.app.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.pizzashift.R
import com.example.pizzashift.app.compose.ErrorComponent
import com.example.pizzashift.app.compose.LoadingComponent
import com.example.pizzashift.app.compose.PizzaMainBlock
import com.example.pizzashift.app.state.PizzaDetailsState
import com.example.pizzashift.app.viewmodel.PizzaDetailsViewModel
import com.example.pizzashift.domain.model.Pizza

@Composable
fun PizzaDetailsScreen(
    viewModel: PizzaDetailsViewModel,
    modifier: Modifier = Modifier
) {
    val pizzaState by viewModel.state.collectAsState()

    when(val state = pizzaState) {

        is PizzaDetailsState.Initial,
        is PizzaDetailsState.Loading -> LoadingComponent()

        is PizzaDetailsState.Failure -> ErrorComponent(
            message = state.message ?: stringResource(id = R.string.error_unknown_error),
            onRetry = { viewModel.getPizza() },
        )

        is PizzaDetailsState.Content -> PizzaDetailsContent(
            pizza = state.pizza,
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PizzaDetailsContent( //Сейчас скроллится не вся страница, а только lazyColumn с ингредиентами
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left),
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
            }

            Text(
                text = stringResource(R.string.pizza_screen_title),
                fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    start = 16.dp,
                    end = 16.dp
                )
        ) {
            GlideImage(
                model = pizza.img,
                contentDescription = pizza.name,
                modifier = Modifier
                    .height(220.dp)
                    .align(Alignment.CenterHorizontally)
            )

            PizzaMainBlock(
                pizza = pizza
            )
        }
    }
}