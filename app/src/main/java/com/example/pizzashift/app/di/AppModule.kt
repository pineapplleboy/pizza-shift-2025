package com.example.pizzashift.app.di

import com.example.pizzashift.app.viewmodel.PizzaCatalogViewModel
import com.example.pizzashift.app.viewmodel.PizzaDetailsViewModel
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