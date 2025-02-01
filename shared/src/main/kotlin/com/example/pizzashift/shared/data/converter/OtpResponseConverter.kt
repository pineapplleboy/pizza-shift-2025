package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.OtpResponseDTO
import com.example.pizzashift.shared.domain.model.OtpResponse

fun OtpResponseDTO.toDomainModel(): OtpResponse {

    return OtpResponse(
        success = this.success,
        reason = this.reason,
        retryDelay = this.retryDelay
    )
}