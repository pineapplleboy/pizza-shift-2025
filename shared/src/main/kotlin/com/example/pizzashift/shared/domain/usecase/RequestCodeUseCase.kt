package com.example.pizzashift.shared.domain.usecase

import com.example.pizzashift.shared.domain.model.OtpResponse
import com.example.pizzashift.shared.domain.repository.ProfileRepository

class RequestCodeUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(phone: String): OtpResponse {
        return repository.requestCode(phone)
    }
}