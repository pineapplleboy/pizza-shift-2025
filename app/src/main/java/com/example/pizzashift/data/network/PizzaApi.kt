package com.example.pizzashift.data.network

import com.example.pizzashift.data.model.CatalogDTO
import retrofit2.http.GET

interface PizzaApi {

    @GET("pizza/catalog")
    suspend fun getPizzaCatalog(): CatalogDTO
}