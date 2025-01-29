package com.example.pizzashift.feature.pizza_catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.shared.domain.usecase.GetPizzaCatalogUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class PizzaCatalogViewModel(
    private val getPizzaCatalogUseCase: GetPizzaCatalogUseCase
): ViewModel() {

    private val _state = MutableStateFlow<PizzaCatalogState>(PizzaCatalogState.Initial)
    val state: StateFlow<PizzaCatalogState> = _state

    init {
        getPizzaCatalog()
    }

    fun getPizzaCatalog() {

        viewModelScope.launch {
            _state.value = PizzaCatalogState.Loading

            try {
                _state.value = PizzaCatalogState.Content(getPizzaCatalogUseCase())
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = PizzaCatalogState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}