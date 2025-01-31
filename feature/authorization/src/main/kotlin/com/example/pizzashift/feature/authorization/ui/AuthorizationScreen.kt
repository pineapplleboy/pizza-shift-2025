package com.example.pizzashift.feature.authorization.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.feature.authorization.presentation.AuthorizationState
import com.example.pizzashift.feature.authorization.presentation.AuthorizationViewModel

@Composable
fun AuthorizationScreen(
    onAuthorized: () -> Unit,
    viewModel: AuthorizationViewModel,
    modifier: Modifier = Modifier
) {
    val authState by viewModel.state.collectAsState()
    val phone = remember { mutableStateOf("") }

    when(val state = authState) {

        is AuthorizationState.Loading -> LoadingComponent()

        is AuthorizationState.Failure -> ErrorComponent(
            message = state.message,
            onRetry = {},
        )

        is AuthorizationState.Phone -> AuthorizationPhoneScreen(
            prevPhone = phone.value,
            modifier = modifier,
            onContinue = {
                phone.value = it
                viewModel.requestCode(it)
            }
        )

        is AuthorizationState.Code -> AuthorizationCodeScreen(
            modifier = modifier,
            prevPhone = phone.value,
            onContinue = {
                viewModel.confirmCode(it, onAuthorized)
            },
            onBack = {
                viewModel.goToPhoneState()
            }
        )

        is AuthorizationState.Confirmed -> onAuthorized()
    }
}

