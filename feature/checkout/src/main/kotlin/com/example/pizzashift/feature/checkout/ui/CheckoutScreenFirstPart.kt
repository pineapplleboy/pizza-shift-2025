package com.example.pizzashift.feature.checkout.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pizzashift.component.OrangeButton
import com.example.pizzashift.component.ScreenHead
import com.example.pizzashift.feature.checkout.R
import com.example.pizzashift.shared.domain.model.PaymentAddress
import com.example.pizzashift.shared.domain.model.PaymentPerson

@Composable
fun CheckoutScreenFirstPart(
    navController: NavController,
    modifier: Modifier = Modifier,
    initPerson: PaymentPerson? = null,
    initAddress: PaymentAddress? = null,
    onContinue: (person: PaymentPerson, address: String) -> Unit
) {
    val firstName = remember { mutableStateOf(initPerson?.firstName.orEmpty()) }
    val lastName = remember { mutableStateOf(initPerson?.lastName.orEmpty()) }
    val phone = remember { mutableStateOf(initPerson?.phone.orEmpty()) }

    val address = remember {
        mutableStateOf(
            listOf(
                initAddress?.street.orEmpty(),
                initAddress?.house.orEmpty(),
                initAddress?.apartment.orEmpty()
            )
            .joinToString(", ")
        )
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ScreenHead(
            name = stringResource(R.string.user_data_hint),
            navController = navController
        )

        Column(
            modifier = modifier.padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            UserInfoField(
                name = stringResource(R.string.second_name_hint),
                value = lastName.value
            ) {
                lastName.value = it
            }

            UserInfoField(
                name = stringResource(R.string.first_name_hint),
                value = firstName.value
            ) {
                firstName.value = it
            }

            UserInfoField(
                name = stringResource(R.string.phone_number_hint),
                value = phone.value
            ) {
                phone.value = it
            }

            UserInfoField(
                name = stringResource(R.string.city_hint),
                value = address.value
            ) {
                address.value = it
            }
        }

        OrangeButton(
            text = stringResource(R.string.continue_checkout),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            onContinue(
                PaymentPerson(
                    firstName = firstName.value,
                    lastName = lastName.value,
                    phone = phone.value
                ),
                address.value
            )
        }
    }
}