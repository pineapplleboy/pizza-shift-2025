package com.example.pizzashift.feature.checkout.domain.usecase

import com.example.pizzashift.shared.domain.model.PaymentDebitCard

class ValidateDebitCardUseCase {

    operator fun invoke(card: PaymentDebitCard): Boolean {
        val cardPan = Regex("^\\d{4} \\d{4}$")
        val cardDate = Regex("^\\d{2}/\\d{2}$")
        val cardCVV = Regex("^\\d{3}$")

        return card.pan.matches(cardPan) && card.expireDate.matches(cardDate) && card.cvv.matches(
            cardCVV
        )
    }
}