package com.example.pizzashift.app.di

import com.example.pizzashift.data.network.PizzaApi
import com.example.pizzashift.data.repository.PizzaRepositoryImpl
import com.example.pizzashift.domain.repository.PizzaRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val logging = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val dataModule = module {
    single {
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl("https://shift-intensive.ru/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    single { get<Retrofit>().create(PizzaApi::class.java) }

    single<PizzaRepository>{
        PizzaRepositoryImpl(get())
    }
}