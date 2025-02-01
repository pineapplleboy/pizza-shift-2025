package com.example.pizzashift.feature.authorization.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.shared.domain.model.SignInBody
import com.example.pizzashift.shared.domain.usecase.RequestCodeUseCase
import com.example.pizzashift.shared.domain.usecase.SignInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class AuthorizationViewModel(
    private val requestCodeUseCase: RequestCodeUseCase,
    private val signInUseCase: SignInUseCase
): ViewModel() {

    private val _state = MutableStateFlow<AuthorizationState>(AuthorizationState.Phone)
    val state: StateFlow<AuthorizationState> = _state.asStateFlow()

    fun requestCode(phone: String) {
        viewModelScope.launch {
            _state.value = AuthorizationState.Loading

            try {
                requestCodeUseCase(phone)
                _state.value = AuthorizationState.Code
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = AuthorizationState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }

    fun confirmCode(signInBody: SignInBody, onContinue: () -> Unit) {
        viewModelScope.launch {
            _state.value = AuthorizationState.Loading

            try {
//                signInUseCase(signInBody)
                onContinue()
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = AuthorizationState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }

    fun goToPhoneState() {
        _state.value = AuthorizationState.Phone
    }
}