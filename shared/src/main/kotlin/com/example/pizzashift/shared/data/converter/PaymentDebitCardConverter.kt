package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.PaymentDebitCardDTO
import com.example.pizzashift.shared.domain.model.PaymentDebitCard

fun PaymentDebitCard.toDTO(): PaymentDebitCardDTO {

    return PaymentDebitCardDTO(
        pan = this.pan,
        expireDate = this.expireDate,
        cvv = this.cvv
    )
}