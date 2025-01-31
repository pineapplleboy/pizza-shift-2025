package com.example.pizzashift.feature.authorization.presentation

sealed interface AuthorizationState {

    data object Loading: AuthorizationState

    data object Phone: AuthorizationState

    data object Code: AuthorizationState

    data object Confirmed: AuthorizationState

    data class Failure(val message: String): AuthorizationState
}