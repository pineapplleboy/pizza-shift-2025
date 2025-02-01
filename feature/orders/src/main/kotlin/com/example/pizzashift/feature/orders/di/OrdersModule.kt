package com.example.pizzashift.feature.orders.di

import com.example.pizzashift.feature.orders.presentation.OrdersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ordersModule = module {
    viewModel<OrdersViewModel> {
        OrdersViewModel()
    }
}