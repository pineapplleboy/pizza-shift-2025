package com.example.pizzashift.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pizzashift.shared.domain.model.PizzaPayment

@Composable
fun OrderInfo(
    pizzaPayment: PizzaPayment,
    paymentPrice: String,
    pizzasDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OrderInfoSegment(
            name = stringResource(R.string.order),
            content = pizzasDescription
        )

        OrderInfoSegment(
            name = stringResource(R.string.address),
            content = listOf(
                pizzaPayment.receiverAddress.street,
                pizzaPayment.receiverAddress.house,
                pizzaPayment.receiverAddress.apartment
            ).joinToString(", ")
        )

        OrderInfoSegment(
            name = stringResource(R.string.final_price),
            content = paymentPrice
        )
    }
}