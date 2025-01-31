package com.example.pizzashift.feature.authorization.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.component.Header
import com.example.pizzashift.component.OrangeButton
import com.example.pizzashift.component.UserInfoField
import com.example.pizzashift.feature.authorization.R

@Composable
fun AuthorizationPhoneScreen(
    prevPhone: String,
    onContinue: (phone: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val phone = remember { mutableStateOf(prevPhone) }

    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Header(
            name = stringResource(R.string.authorization_header)
        )

        Text(
            text = stringResource(R.string.insert_phone_hint),
            fontSize = 16.sp
        )

        UserInfoField(
            value = phone.value
        ) {
            phone.value = it
        }

        OrangeButton(
            text = stringResource(R.string.continue_authorization)
        ) {
            onContinue(phone.value)
        }
    }
}