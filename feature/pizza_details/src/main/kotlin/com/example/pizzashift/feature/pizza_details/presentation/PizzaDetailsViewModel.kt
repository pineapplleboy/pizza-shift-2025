package com.example.pizzashift.feature.pizza_details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.shared.domain.usecase.GetPizzaCatalogUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class PizzaDetailsViewModel(
    private val getPizzaCatalogUseCase: GetPizzaCatalogUseCase,
    private val pizzaId: String
): ViewModel() {

    private val _state = MutableStateFlow<PizzaDetailsState>(PizzaDetailsState.Initial)
    val state: StateFlow<PizzaDetailsState> = _state

    init {
        getPizza()
    }

    fun getPizza() {

        viewModelScope.launch {
            _state.value = PizzaDetailsState.Loading

            try {
                _state.value = PizzaDetailsState.Content(getPizzaCatalogUseCase().first { it.id == pizzaId })
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = PizzaDetailsState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}