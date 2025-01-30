package com.example.pizzashift.feature.checkout.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.feature.checkout.domain.usecase.OrderPizzaUseCase
import com.example.pizzashift.shared.domain.model.PizzaPayment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class CheckoutViewModel(
    private val orderPizzaUseCase: OrderPizzaUseCase
): ViewModel(){

    private val _state = MutableStateFlow<CheckoutState>(CheckoutState.Initial)
    val state: StateFlow<CheckoutState> = _state.asStateFlow()

    fun orderPizza(payment: PizzaPayment) {
        viewModelScope.launch {
            _state.value = CheckoutState.Loading

            try {
                orderPizzaUseCase(payment)
                _state.value = CheckoutState.Content
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = CheckoutState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}