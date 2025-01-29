package com.example.pizzashift.di

import com.example.pizzashift.shared.domain.usecase.GetPizzaCatalogUseCase
import org.koin.dsl.module

val domainModule =  module {
    factory<GetPizzaCatalogUseCase>{
        GetPizzaCatalogUseCase(get())
    }
}