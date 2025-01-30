package com.example.pizzashift.feature.cart.domain.usecase

import com.example.pizzashift.shared.domain.repository.CartRepository

class GetCartUseCase(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke() = cartRepository.getCart()
}