package com.example.pizzashift.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzashift.domain.model.Pizza
import com.example.pizzashift.domain.usecase.GetPizzaCatalogUseCase
import kotlinx.coroutines.launch

class PizzaCatalogViewModel(
    private val getPizzaCatalogUseCase: GetPizzaCatalogUseCase
): ViewModel() {

    private val _pizzas = MutableLiveData<List<Pizza>?>()
    val pizzas: LiveData<List<Pizza>?> = _pizzas

    init {
        getPizzaCatalog()
    }

    private fun getPizzaCatalog() {
        viewModelScope.launch {
            _pizzas.value = getPizzaCatalogUseCase()
        }
    }
}