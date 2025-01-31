package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.SignInResponseDTO
import com.example.pizzashift.shared.domain.model.SignInResponse

fun SignInResponseDTO.toDomainModel(): SignInResponse {

    return SignInResponse(
        success = this.success,
        reason = this.reason,
        user = this.user.toDomainModel(),
        token = this.token
    )
}