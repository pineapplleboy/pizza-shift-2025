package com.example.pizzashift.shared.data.network

import com.example.pizzashift.shared.data.model.CatalogDTO
import com.example.pizzashift.shared.data.model.PizzaPaymentDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PizzaApi {

    @GET("pizza/catalog")
    suspend fun getPizzaCatalog(): CatalogDTO

    @POST("pizza/payment")
    suspend fun orderPizza(@Body payment: PizzaPaymentDTO)
}