package com.example.pizzashift.feature.checkout.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.feature.checkout.presentation.CheckoutState
import com.example.pizzashift.feature.checkout.presentation.CheckoutViewModel
import com.example.pizzashift.shared.domain.model.PaymentAddress
import com.example.pizzashift.shared.domain.model.PaymentPerson

@Composable
fun CheckoutScreen(
    viewModel: CheckoutViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val checkoutState by viewModel.state.collectAsState()

    val paymentPerson = remember { mutableStateOf<PaymentPerson?>(null) }
    val paymentAddress = remember { mutableStateOf<PaymentAddress?>(null) }

    when(val state = checkoutState) {

        is CheckoutState.FirstPart -> CheckoutScreenFirstPart(
            modifier = modifier,
            initPerson = paymentPerson.value,
            initAddress = paymentAddress.value,
            navController = navController
        ) { person, address ->

            paymentPerson.value = person

            val parts = address.split(",").map { it.trim() }

            paymentAddress.value = PaymentAddress(
                street = parts.getOrNull(0) ?: "",
                house = parts.getOrNull(1) ?: "",
                apartment = parts.getOrNull(2) ?: "",
                comment = parts.getOrNull(3)
            )

            viewModel.validateFirstPart(paymentPerson.value!!, paymentAddress.value!!)
        }

        is CheckoutState.SecondPart -> CheckoutScreenSecondPart(
            modifier = modifier,
            onBack = {
                viewModel.goToFirstPart()
            },
            onContinue = {

                if(paymentAddress.value != null && paymentPerson.value != null) {

                    viewModel.validateSecondPartAndOrder(
                        address = paymentAddress.value!!,
                        paymentPerson = paymentPerson.value!!,
                        card = it
                    )
                }
            }
        )

        is CheckoutState.Success -> CheckoutScreenSuccess(
            modifier = modifier,
            pizzasDescription = state.pizzasDescription,
            pizzaPayment = state.pizzaPayment,
            paymentPrice = state.paymentPrice
        )

        is CheckoutState.Loading -> LoadingComponent()

        is CheckoutState.Failure -> ErrorComponent(
            message = state.message,
            onRetry = {
                viewModel.goToFirstPart()
            },
        )
    }
}