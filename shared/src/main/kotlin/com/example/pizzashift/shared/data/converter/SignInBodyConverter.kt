package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.SignInBodyDTO
import com.example.pizzashift.shared.domain.model.SignInBody

fun SignInBody.toDTO(): SignInBodyDTO {

    return SignInBodyDTO(
        phone = this.phone,
        code = this.code
    )
}