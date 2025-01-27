package com.example.pizzashift.app.di

import com.example.pizzashift.app.viewmodel.PizzaCatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PizzaCatalogViewModel> {
        PizzaCatalogViewModel(get())
    }
}