package com.example.pizzashift.shared.di

import com.example.pizzashift.shared.domain.usecase.ClearCartUseCase
import com.example.pizzashift.shared.domain.usecase.CountPizzaPriceUseCase
import com.example.pizzashift.shared.domain.usecase.DeletePizzaFromCartUseCase
import com.example.pizzashift.shared.domain.usecase.GetCartUseCase
import com.example.pizzashift.shared.domain.usecase.GetPizzaCatalogUseCase
import com.example.pizzashift.shared.domain.usecase.MakePizzaDescriptionUseCase
import com.example.pizzashift.shared.domain.usecase.RequestCodeUseCase
import com.example.pizzashift.shared.domain.usecase.SignInUseCase
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

    factory<SignInUseCase> {
        SignInUseCase(get())
    }

    factory<RequestCodeUseCase> {
        RequestCodeUseCase(get())
    }

    factory<ClearCartUseCase> {
        ClearCartUseCase(get())
    }

    factory<DeletePizzaFromCartUseCase> {
        DeletePizzaFromCartUseCase(get())
    }
}