package com.example.pizzashift.feature.checkout.domain.usecase

class ValidatePhoneUseCase {

    operator fun invoke(phone: String): Boolean {
        val phoneRegex = Regex("^8\\d{10}\$")

        return phone.matches(phoneRegex)
    }
}