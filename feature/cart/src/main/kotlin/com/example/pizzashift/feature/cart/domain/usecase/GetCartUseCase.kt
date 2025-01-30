package com.example.pizzashift.feature.cart.domain.usecase

import com.example.pizzashift.shared.domain.repository.CartRepository

class GetCartUseCase(
    private val cartRepository: CartRepository
) {
    operator fun invoke() = cartRepository.getCart()
}