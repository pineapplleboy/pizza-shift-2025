package com.example.pizzashift.feature.cart.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.feature.cart.presentation.CartState
import com.example.pizzashift.feature.cart.presentation.CartViewModel
import com.example.pizzashift.shared.R

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