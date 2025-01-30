package com.example.pizzashift.feature.pizza_details.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.feature.pizza_details.domain.usecase.AddPizzaToCartUseCase
import com.example.pizzashift.shared.domain.model.OrderedPizza
import com.example.pizzashift.shared.domain.model.OrderedPizzaIngredient
import com.example.pizzashift.shared.domain.model.Pizza
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.PizzaIngredient
import com.example.pizzashift.shared.domain.model.PizzaSize
import com.example.pizzashift.shared.domain.usecase.GetPizzaCatalogUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

class PizzaDetailsViewModel(
    private val getPizzaCatalogUseCase: GetPizzaCatalogUseCase,
    private val addPizzaToCartUseCase: AddPizzaToCartUseCase,
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

    fun addPizzaToCart(pizza: Pizza, size: PizzaSize, dough: PizzaDough, toppings: List<PizzaIngredient>) {

        viewModelScope.launch {
            addPizzaToCartUseCase(
                OrderedPizza(
                    id = pizza.id,
                    name = pizza.name,
                    toppings = toppings.map { OrderedPizzaIngredient(it.name, it.cost) },
                    size = size,
                    doughs = dough,
                    img = pizza.img
                )
            )
        }
    }
}