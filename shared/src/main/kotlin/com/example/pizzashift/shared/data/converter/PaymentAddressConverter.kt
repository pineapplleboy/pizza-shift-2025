package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.PaymentAddressDTO
import com.example.pizzashift.shared.domain.model.PaymentAddress

fun PaymentAddress.toDTO(): PaymentAddressDTO {

    return PaymentAddressDTO(
        street = this.street,
        house = this.house,
        apartment = this.apartment,
        comment = this.comment
    )
}