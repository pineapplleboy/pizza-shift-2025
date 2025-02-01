package com.example.pizzashift.feature.checkout.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzashift.component.OrderInfo
import com.example.pizzashift.feature.checkout.R
import com.example.pizzashift.shared.domain.model.PizzaPayment

@Composable
fun CheckoutScreenSuccess(
    pizzaPayment: PizzaPayment,
    paymentPrice: String,
    pizzasDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.End)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(R.string.close_button_description)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(com.example.pizzashift.shared.R.drawable.tick),
                contentDescription = null,
                modifier = Modifier.size(80.dp).align(Alignment.CenterHorizontally)
            )

            Text(
                text = stringResource(R.string.successfull_order),
                fontFamily = FontFamily(Font(com.example.pizzashift.shared.R.font.montserrat_font_family)),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            OrderInfo(
                pizzaPayment = pizzaPayment,
                paymentPrice = paymentPrice,
                pizzasDescription = pizzasDescription
            )
        }
    }
}