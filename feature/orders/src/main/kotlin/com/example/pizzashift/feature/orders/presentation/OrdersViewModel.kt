package com.example.pizzashift.feature.orders.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrdersViewModel(
) : ViewModel() {
    //Просто экранчик для красоты, не работает, т.к. понадобилась бы авторизация, а код с смской не приходит(
    private val _state = MutableStateFlow<OrdersState>(OrdersState.Initial)
    val state: StateFlow<OrdersState> = _state.asStateFlow()

    init {
        getOrders()
    }

    fun getOrders() {
        _state.value = OrdersState.Content(listOf())
    }
}