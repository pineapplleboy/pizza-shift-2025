package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.PaymentPersonDTO
import com.example.pizzashift.shared.domain.model.PaymentPerson

fun PaymentPerson.toDTO(): PaymentPersonDTO {

    return PaymentPersonDTO(
        firstname = this.firstName,
        lastname = this.lastName,
        middlename = this.middleName,
        phone = this.phone
    )
}