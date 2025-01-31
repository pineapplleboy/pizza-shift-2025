package com.example.pizzashift.feature.checkout.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pizzashift.component.OrangeButton
import com.example.pizzashift.component.ScreenHead
import com.example.pizzashift.feature.checkout.R
import com.example.pizzashift.shared.domain.model.PaymentDebitCard

@Composable
fun CheckoutScreenSecondPart(
    onBack: () -> Unit,
    onContinue: (PaymentDebitCard) -> Unit,
    modifier: Modifier = Modifier
) {
    val pan = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val cvv = remember { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ScreenHead(
            name = stringResource(R.string.checkout_second_screen),
            onBack = onBack
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            UserInfoField(
                name = stringResource(R.string.card_pan_hint),
                value = pan.value
            ) {
                pan.value = it
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                UserInfoField(
                    name = stringResource(R.string.card_date_hint),
                    value = date.value,
                    modifier = Modifier.weight(1f)
                ) {
                    date.value = it
                }

                UserInfoField(
                    name = stringResource(R.string.card_cvv_hint),
                    value = cvv.value,
                    modifier = Modifier.weight(1f)
                ) {
                    cvv.value = it
                }
            }
        }

        OrangeButton(
            text = stringResource(R.string.pay_for_pizza_hint),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            onContinue(
                PaymentDebitCard(
                    pan = pan.value,
                    expireDate = date.value,
                    cvv = cvv.value
                )
            )
        }
    }
}