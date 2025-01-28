package com.example.pizzashift.app.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.R
import com.example.pizzashift.app.state.PizzaCatalogState
import com.example.pizzashift.app.viewmodel.PizzaCatalogViewModel
import com.example.pizzashift.domain.model.Pizza

@Composable
fun PizzaCatalogScreen(
    vm: PizzaCatalogViewModel,
    modifier: Modifier = Modifier
) {

    val pizzaState by vm.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pizza Catalog",
            fontFamily = FontFamily(Font(R.font.montserrat_font_family)),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        when(val state = pizzaState) {

            is PizzaCatalogState.Initial,
            is PizzaCatalogState.Loading -> LoadingComponent()

            is PizzaCatalogState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = { vm.getPizzaCatalog() },
            )

            is PizzaCatalogState.Content -> LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.pizzas) { pizza ->
                    PizzaCard(pizza = pizza)
                }
            }
        }
    }
}