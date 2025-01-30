package com.example.pizzashift.feature.cart.di

import com.example.pizzashift.feature.cart.domain.usecase.GetCartUseCase
import com.example.pizzashift.feature.cart.presentation.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartModule = module {
    viewModel<CartViewModel> {
            CartViewModel(get())
    }

    factory<GetCartUseCase> {
        GetCartUseCase(get())
    }
}