package com.example.pizzashift.feature.authorization.di

import com.example.pizzashift.feature.authorization.presentation.AuthorizationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authorizationModule = module {
    viewModel<AuthorizationViewModel> {
        AuthorizationViewModel(get(), get())
    }
}