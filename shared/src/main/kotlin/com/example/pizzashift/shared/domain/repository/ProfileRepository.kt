package com.example.pizzashift.shared.domain.repository

import com.example.pizzashift.shared.domain.model.OtpResponse
import com.example.pizzashift.shared.domain.model.SignInBody
import com.example.pizzashift.shared.domain.model.SignInResponse

interface ProfileRepository {

    suspend fun requestCode(phone: String): OtpResponse

    suspend fun signIn(signInBody: SignInBody): SignInResponse
}