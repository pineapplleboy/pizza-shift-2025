package com.example.pizzashift.feature.pizza_catalog.di

import com.example.pizzashift.feature.pizza_catalog.presentation.PizzaCatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val pizzaCatalogModule = module {
    viewModel<PizzaCatalogViewModel> {
        PizzaCatalogViewModel(get())
    }
}