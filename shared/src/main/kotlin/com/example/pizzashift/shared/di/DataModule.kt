package com.example.pizzashift.shared.di

import androidx.room.Room
import com.example.pizzashift.shared.data.DataConstants
import com.example.pizzashift.shared.data.database.PizzaDatabase
import com.example.pizzashift.shared.data.network.PizzaApi
import com.example.pizzashift.shared.data.repository.CartRepositoryImpl
import com.example.pizzashift.shared.data.repository.PizzaRepositoryImpl
import com.example.pizzashift.shared.domain.repository.CartRepository
import com.example.pizzashift.shared.domain.repository.PizzaRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
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
            .baseUrl(DataConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    single { get<Retrofit>().create(PizzaApi::class.java) }

    single {
        Room.databaseBuilder(
            androidApplication(),
            PizzaDatabase::class.java,
            "pizza_database"
        ).build()
    }

    single { get<PizzaDatabase>().pizzaDao() }

    factory<PizzaRepository>{
        PizzaRepositoryImpl(get())
    }

    factory<CartRepository>{
        CartRepositoryImpl(get())
    }
}