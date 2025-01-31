package com.example.pizzashift.shared.data.network

import com.example.pizzashift.shared.data.model.CatalogDTO
import com.example.pizzashift.shared.data.model.OtpResponseDTO
import com.example.pizzashift.shared.data.model.PhoneDTO
import com.example.pizzashift.shared.data.model.PizzaPaymentDTO
import com.example.pizzashift.shared.data.model.SignInBodyDTO
import com.example.pizzashift.shared.data.model.SignInResponseDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PizzaApi {

    @GET("pizza/catalog")
    suspend fun getPizzaCatalog(): CatalogDTO

    @POST("pizza/payment")
    suspend fun orderPizza(@Body payment: PizzaPaymentDTO)

    @POST("auth/otp")
    suspend fun requestCode(@Body phone: PhoneDTO): OtpResponseDTO

    @POST("users/signin")
    suspend fun signIn(@Body signInBodyDTO: SignInBodyDTO): SignInResponseDTO
}