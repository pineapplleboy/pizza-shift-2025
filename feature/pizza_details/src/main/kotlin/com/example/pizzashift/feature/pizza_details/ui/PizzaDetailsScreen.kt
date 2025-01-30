package com.example.pizzashift.feature.pizza_details.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.pizzashift.shared.R
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.component.ScreenHead
import com.example.pizzashift.feature.pizza_details.presentation.PizzaDetailsState
import com.example.pizzashift.feature.pizza_details.presentation.PizzaDetailsViewModel
import com.example.pizzashift.shared.domain.model.Pizza
import com.example.pizzashift.shared.domain.model.PizzaIngredient

@Composable
fun PizzaDetailsScreen(
    viewModel: PizzaDetailsViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val pizzaState by viewModel.state.collectAsState()

    when (val state = pizzaState) {

        is PizzaDetailsState.Initial,
        is PizzaDetailsState.Loading -> LoadingComponent()

        is PizzaDetailsState.Failure -> ErrorComponent(
            message = state.message ?: stringResource(id = R.string.error_unknown_error),
            onRetry = { viewModel.getPizza() },
        )

        is PizzaDetailsState.Content -> PizzaDetailsContent(
            pizza = state.pizza,
            viewModel = viewModel,
            navController = navController,
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PizzaDetailsContent(
    pizza: Pizza,
    viewModel: PizzaDetailsViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val size = remember { mutableStateOf(pizza.sizes[0]) }
    val toppings = remember { mutableStateOf(listOf<PizzaIngredient>()) } //пока что не изменяются

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item(
            span = { GridItemSpan(3) }
        ) {
            Column {
                ScreenHead(
                    navController = navController,
                    name = stringResource(R.string.pizza_screen_title)
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            Column {
                GlideImage(
                    model = pizza.img,
                    contentDescription = pizza.name,
                    modifier = Modifier
                        .height(220.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(32.dp))
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            Column {
                PizzaMainInfo(pizza)
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            Column {
                PizzaSizeBlock(
                    currentSize = size.value
                ) {
                    size.value = pizza.sizes.first { cur -> cur.name.name == it.name }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            Column {
                Text(
                    text = stringResource(com.example.pizzashift.feature.pizza_details.R.string.add_topping_hint),
                    fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        items(
            items = pizza.toppings
        ) { topping ->
            Column {
                ToppingCard(
                    topping = topping
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            Column {
                Spacer(modifier = Modifier.height(24.dp))
                TextButton(
                    onClick = {
                        viewModel.addPizzaToCart(
                            pizza = pizza,
                            size = size.value,
                            dough = pizza.doughs[0], //тесто временно по дефолту первое
                            toppings = toppings.value
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.Black,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Text(
                        text = stringResource(com.example.pizzashift.feature.pizza_details.R.string.add_to_cart),
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}