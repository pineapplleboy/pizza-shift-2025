package com.example.pizzashift.shared.domain.usecase

import com.example.pizzashift.shared.domain.repository.CartRepository

class ClearCartUseCase(
    val repository: CartRepository
) {

    suspend operator fun invoke() {
        repository.clearCart()
    }
}