package com.example.pizzashift.feature.checkout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pizzashift.component.ErrorComponent
import com.example.pizzashift.component.LoadingComponent
import com.example.pizzashift.component.OrangeButton
import com.example.pizzashift.component.ScreenHead
import com.example.pizzashift.feature.checkout.R
import com.example.pizzashift.feature.checkout.presentation.CheckoutState
import com.example.pizzashift.feature.checkout.presentation.CheckoutViewModel

@Composable
fun CheckoutScreen(
    viewModel: CheckoutViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val checkoutState by viewModel.state.collectAsState()

    when(val state = checkoutState) {

        is CheckoutState.Initial -> CheckoutScreenContent(
            modifier = modifier,
            navController = navController
        )

        is CheckoutState.Loading -> LoadingComponent()

        is CheckoutState.Failure -> ErrorComponent(
            message = state.message,
            onRetry = {},
        )

        is CheckoutState.Content -> {
            CheckoutScreenContent(
                modifier = modifier,
                navController = navController
            )
        }
    }
}

@Composable
fun CheckoutScreenContent(
    navController: NavController,
    modifier: Modifier = Modifier
) {
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
                name = stringResource(R.string.second_name_hint)
            )

            UserInfoField(
                name = stringResource(R.string.first_name_hint)
            )

            UserInfoField(
                name = stringResource(R.string.phone_number_hint)
            )

            UserInfoField(
                name = stringResource(R.string.email_hint)
            )

            UserInfoField(
                name = stringResource(R.string.city_hint)
            )
        }

        OrangeButton(
            text = stringResource(R.string.continue_checkout),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            
        }
    }
}

@Composable
fun UserInfoField(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = name,
            fontFamily = FontFamily(Font(com.example.pizzashift.shared.R.font.montserrat_font_family)),
            fontSize = 14.sp
        )

        TextField(
            value = "",
            onValueChange = {},
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedContainerColor = colorResource(com.example.pizzashift.shared.R.color.ghost_white),
                unfocusedContainerColor = colorResource(com.example.pizzashift.shared.R.color.ghost_white),
            ),
            modifier = Modifier
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
        )
    }
}

@Preview
@Composable
fun CheckoutScreenPreview() {
    CheckoutScreenContent(
        navController = rememberNavController(),
        modifier = Modifier.background(color = Color.White)
    )
}