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
import com.example.pizzashift.shared.domain.model.SignInBody

@Composable
fun AuthorizationCodeScreen(
    prevPhone: String,
    onBack: () -> Unit,
    onContinue: (SignInBody) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        val phone = remember { mutableStateOf(prevPhone) }
        val code = remember { mutableStateOf("") }

        Header(
            name = stringResource(R.string.authorization_header),
            onBack = onBack
        )

        Text(
            text = stringResource(R.string.insert_code_hint),
            fontSize = 16.sp
        )

        UserInfoField(
            value = phone.value
        ) {
            phone.value = it
        }

        UserInfoField(
            value = code.value
        ) {
            code.value = it
        }

        OrangeButton(
            text = stringResource(R.string.continue_authorization)
        ) {
            onContinue(SignInBody(phone.value, code.value))
        }
    }
}