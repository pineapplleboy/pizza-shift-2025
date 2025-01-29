package com.example.pizzashift.di

import com.example.pizzashift.feature.pizza_catalog.presentation.PizzaCatalogViewModel
import com.example.pizzashift.feature.pizza_details.presentation.PizzaDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PizzaCatalogViewModel> {
        PizzaCatalogViewModel(get())
    }
    viewModel<PizzaDetailsViewModel> {
        (pizzaId: String) -> PizzaDetailsViewModel(get(), pizzaId)
    }
}