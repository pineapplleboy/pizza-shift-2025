package com.example.pizzashift.app.di

import com.example.pizzashift.domain.usecase.GetPizzaCatalogUseCase
import org.koin.dsl.module

val domainModule =  module {
    factory<GetPizzaCatalogUseCase>{
        GetPizzaCatalogUseCase(get())
    }
}