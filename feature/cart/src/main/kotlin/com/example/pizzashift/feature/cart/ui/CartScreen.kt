package com.example.pizzashift.feature.cart.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.component.ScreenHead
import com.example.pizzashift.feature.cart.presentation.CartState
import com.example.pizzashift.feature.cart.presentation.CartViewModel
import com.example.pizzashift.shared.R
import com.example.pizzashift.shared.domain.model.DoughType
import com.example.pizzashift.shared.domain.model.IngredientType
import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.model.OrderedPizzaIngredient
import com.example.pizzashift.shared.domain.model.Pizza
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.PizzaSize
import com.example.pizzashift.shared.domain.model.SizeType

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

        is CartState.Content -> {}
    }
}

@Composable
fun CartScreenContent(
    pizzas: List<OrderedPizza>,
    modifier: Modifier = Modifier
) {
    Column() {
        ScreenHead(stringResource(R.string.cart_screen_title))


    }
}

@Preview
@Composable
fun CartScreenContentPreview() {
    CartScreenContent(
        pizzas = listOf(
            OrderedPizza(
                id = "1",
                name = "Mafia Supreme",
                toppings = listOf(
                    OrderedPizzaIngredient(IngredientType.MOZZARELLA, 3.0),
                    OrderedPizzaIngredient(IngredientType.PEPERONI, 2.5),
                    OrderedPizzaIngredient(IngredientType.BACON, 3.5)
                ),
                doughs = PizzaDough(DoughType.THIN, 1.0),
                size = PizzaSize(SizeType.SMALL, 5.0),
                img = ""
            )
        )
    )
}