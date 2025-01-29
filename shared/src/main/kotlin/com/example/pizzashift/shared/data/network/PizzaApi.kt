package com.example.pizzashift.shared.data.network

import com.example.pizzashift.shared.data.model.CatalogDTO
import retrofit2.http.GET

interface PizzaApi {

    @GET("pizza/catalog")
    suspend fun getPizzaCatalog(): CatalogDTO
}