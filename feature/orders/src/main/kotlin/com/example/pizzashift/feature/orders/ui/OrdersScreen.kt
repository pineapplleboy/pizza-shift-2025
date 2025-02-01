package com.example.pizzashift.feature.orders.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.Header
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.component.OrderInfo
import com.example.pizzashift.feature.orders.R
import com.example.pizzashift.shared.domain.model.PizzaOrder
import com.example.pizzashift.feature.orders.presentation.OrdersState
import com.example.pizzashift.feature.orders.presentation.OrdersViewModel
import com.example.pizzashift.shared.domain.model.DoughType
import com.example.pizzashift.shared.domain.model.IngredientType
import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.model.OrderedPizzaIngredient
import com.example.pizzashift.shared.domain.model.PaymentAddress
import com.example.pizzashift.shared.domain.model.PaymentDebitCard
import com.example.pizzashift.shared.domain.model.PaymentPerson
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.PizzaPayment
import com.example.pizzashift.shared.domain.model.PizzaSize
import com.example.pizzashift.shared.domain.model.SizeType
import com.example.pizzashift.shared.domain.usecase.CountPizzaPriceUseCase
import com.example.pizzashift.shared.domain.usecase.MakePizzaDescriptionUseCase

@Composable
fun OrdersScreen(
    viewModel: OrdersViewModel,
    modifier: Modifier = Modifier
) {
    val ordersState by viewModel.state.collectAsState()

    when(val state = ordersState) {

        is OrdersState.Initial,
        is OrdersState.Loading -> LoadingComponent()

        is OrdersState.Failure -> ErrorComponent(
            message = state.message,
            onRetry = {},
        )

        is OrdersState.Content -> {
            OrdersScreenContent(
                modifier = modifier
            )
        }
    }
}

@Composable
fun OrdersScreenContent(
    orders: List<PizzaOrder> = listOf(
        PizzaOrder(
            pizzas = listOf(
                OrderedPizza(
                    id = "",
                    name = "Mega Pizza",
                    toppings = listOf(
                        OrderedPizzaIngredient(
                            name = IngredientType.HAM,
                            cost = 10.2
                        )
                    ),
                    size = PizzaSize(name = SizeType.MEDIUM, 10.0),
                    doughs = PizzaDough(name = DoughType.THIN, 10.0),
                    img = ""
                )
            ),
            person = PaymentPerson(
                firstName = "Nastoyashiy",
                lastName = "Chelovek",
                middleName = "Otvechau",
                phone = "81234567890"
            ),
            receiverAddress = PaymentAddress(
                street = "ulitsa",
                house = "1",
                apartment = "1",
                comment = ""
            ),
            status = 0,
            cancellable = true
        )
    ),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Header(
            name = stringResource(R.string.orders_header)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(orders) {
                OrderItem(it)
            }
        }
    }
}

@Composable
fun OrderItem(
    order: PizzaOrder,
    modifier: Modifier = Modifier
) {
    val makePizzaDescriptionUseCase = MakePizzaDescriptionUseCase()
    val countPizzaPriceUseCase = CountPizzaPriceUseCase()

    OrderInfo(
        pizzaPayment = PizzaPayment(
            receiverAddress = order.receiverAddress,
            person = order.person,
            debitCard = PaymentDebitCard("","",""),
            pizzas = order.pizzas
        ),
        paymentPrice = order.pizzas.sumOf { countPizzaPriceUseCase(it) }.toString(),
        pizzasDescription = order.pizzas.joinToString(separator = "\n") { makePizzaDescriptionUseCase(it) },
        modifier = modifier
    )
}