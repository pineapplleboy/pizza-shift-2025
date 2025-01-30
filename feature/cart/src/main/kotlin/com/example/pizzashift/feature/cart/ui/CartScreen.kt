package com.example.pizzashift.feature.cart.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.component.ScreenHead
import com.example.pizzashift.feature.cart.presentation.CartState
import com.example.pizzashift.feature.cart.presentation.CartViewModel
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.OrderedPizza

@Composable
fun CartScreen(
    viewModel: CartViewModel,
    modifier: Modifier = Modifier
) {
    val cartState by viewModel.state.collectAsState()

    when(val state = cartState) {

        is CartState.Initial,
        is CartState.Loading -> LoadingComponent()

        is CartState.Failure -> ErrorComponent(
            message = state.message ?: stringResource(id = R.string.error_unknown_error),
            onRetry = {},
        )

        is CartState.Content -> {
            CartScreenContent(
                pizzas = state.pizzas,
                modifier = modifier
            )
        }
    }
}

@Composable
fun CartScreenContent(
    pizzas: List<OrderedPizza>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color.White)
    ) {
        ScreenHead(stringResource(R.string.cart_screen_title))

        LazyColumn(
            contentPadding = PaddingValues(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            items(pizzas) {
                CartPizzaItem(
                    pizza = it
                )
            }
        }
    }
}