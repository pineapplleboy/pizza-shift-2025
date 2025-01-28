package com.example.pizzashift.data.model

data class CatalogDTO(
    val success: Boolean,
    val reason: String?, //Каталог в ответе есть всегда, но пока проверял, заметил, что иногда есть ещё reason))
    val catalog: List<PizzaDTO>
)