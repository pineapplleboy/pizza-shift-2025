package com.example.pizzashift.shared.di

import com.example.pizzashift.shared.domain.usecase.CountPizzaPriceUseCase
import com.example.pizzashift.shared.domain.usecase.GetCartUseCase
import com.example.pizzashift.shared.domain.usecase.GetPizzaCatalogUseCase
import com.example.pizzashift.shared.domain.usecase.MakePizzaDescriptionUseCase
import org.koin.dsl.module

val domainModule =  module {
    factory<GetPizzaCatalogUseCase>{
        GetPizzaCatalogUseCase(get())
    }

    factory<MakePizzaDescriptionUseCase>{
        MakePizzaDescriptionUseCase()
    }

    factory<CountPizzaPriceUseCase> {
        CountPizzaPriceUseCase()
    }
}