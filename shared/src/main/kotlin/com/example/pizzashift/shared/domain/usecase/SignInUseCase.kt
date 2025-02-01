package com.example.pizzashift.shared.domain.usecase

import com.example.pizzashift.shared.domain.model.SignInBody
import com.example.pizzashift.shared.domain.model.SignInResponse
import com.example.pizzashift.shared.domain.repository.ProfileRepository

class SignInUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(signInBody: SignInBody): SignInResponse {
        return repository.signIn(signInBody)
    }
}