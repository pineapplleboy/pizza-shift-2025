package com.example.pizzashift.feature.pizza_details.ui

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
import com.example.pizzashift.shared.R
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.component.ScreenHead
import com.example.pizzashift.feature.pizza_details.presentation.PizzaDetailsState
import com.example.pizzashift.feature.pizza_details.presentation.PizzaDetailsViewModel
import com.example.pizzashift.shared.domain.model.Pizza

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
        ScreenHead(stringResource(R.string.pizza_screen_title))

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