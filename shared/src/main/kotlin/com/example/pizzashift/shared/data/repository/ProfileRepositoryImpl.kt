package com.example.pizzashift.shared.data.repository

import com.example.pizzashift.shared.data.converter.toDTO
import com.example.pizzashift.shared.data.converter.toDomainModel
import com.example.pizzashift.shared.data.model.PhoneDTO
import com.example.pizzashift.shared.data.network.PizzaApi
import com.example.pizzashift.shared.domain.model.OtpResponse
import com.example.pizzashift.shared.domain.model.SignInBody
import com.example.pizzashift.shared.domain.model.SignInResponse
import com.example.pizzashift.shared.domain.repository.ProfileRepository

class ProfileRepositoryImpl(
    private val api: PizzaApi
): ProfileRepository {

    override suspend fun requestCode(phone: String): OtpResponse {
        return api.requestCode(PhoneDTO(phone)).toDomainModel()
    }

    override suspend fun signIn(signInBody: SignInBody): SignInResponse {
        return api.signIn(signInBody.toDTO()).toDomainModel()
    }
}