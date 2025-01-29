package com.example.pizzashift.feature.cart.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel: ViewModel() {

    private val _state = MutableStateFlow<CartState>(CartState.Initial)
    val state: StateFlow<CartState> = _state.asStateFlow()
}