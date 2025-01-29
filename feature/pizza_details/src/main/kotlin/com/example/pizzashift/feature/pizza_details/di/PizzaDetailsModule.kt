package com.example.pizzashift.feature.pizza_details.di

import com.example.pizzashift.feature.pizza_details.presentation.PizzaDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pizzaDetailsModule = module {
    viewModel<PizzaDetailsViewModel> {
            (pizzaId: String) -> PizzaDetailsViewModel(get(), pizzaId)
    }
}