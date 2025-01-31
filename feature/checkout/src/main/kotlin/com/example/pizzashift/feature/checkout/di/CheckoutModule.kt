package com.example.pizzashift.feature.checkout.di

import com.example.pizzashift.feature.checkout.data.repository.CheckoutRepositoryImpl
import com.example.pizzashift.feature.checkout.domain.repository.CheckoutRepository
import com.example.pizzashift.feature.checkout.domain.usecase.OrderPizzaUseCase
import com.example.pizzashift.feature.checkout.domain.usecase.ValidateDebitCardUseCase
import com.example.pizzashift.feature.checkout.domain.usecase.ValidatePhoneUseCase
import com.example.pizzashift.feature.checkout.presentation.CheckoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val checkoutModule = module {
    viewModel<CheckoutViewModel> {
        CheckoutViewModel(get(), get(), get(), get(), get(), get())
    }

    factory<OrderPizzaUseCase> {
        OrderPizzaUseCase(get())
    }

    factory<ValidatePhoneUseCase> {
        ValidatePhoneUseCase()
    }

    factory<ValidateDebitCardUseCase> {
        ValidateDebitCardUseCase()
    }

    factory<CheckoutRepository> {
        CheckoutRepositoryImpl(get())
    }
}