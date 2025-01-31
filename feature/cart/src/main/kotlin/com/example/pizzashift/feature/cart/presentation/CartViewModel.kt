package com.example.pizzashift.feature.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.shared.domain.usecase.GetCartUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class CartViewModel(
    private val getCartUseCase: GetCartUseCase
): ViewModel() {

    private val _state = MutableStateFlow<CartState>(CartState.Initial)
    val state: StateFlow<CartState> = _state.asStateFlow()

    init {
        getCart()
    }

    fun getCart() {
        viewModelScope.launch {
            _state.value = CartState.Loading

            try {
                _state.value = CartState.Content(getCartUseCase())
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = CartState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}