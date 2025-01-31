package com.example.pizzashift.shared.data.converter

import androidx.room.TypeConverter
import com.example.pizzashift.shared.domain.model.OrderedPizzaIngredient
import com.example.pizzashift.shared.domain.model.PizzaDough
import com.example.pizzashift.shared.domain.model.PizzaSize
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PizzaDatabaseConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromIngredientList(value: List<OrderedPizzaIngredient>): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toIngredientList(value: String): List<OrderedPizzaIngredient> {
        val type = object : TypeToken<List<OrderedPizzaIngredient>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromPizzaSize(value: PizzaSize): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPizzaSize(value: String): PizzaSize {
        val type = object : TypeToken<PizzaSize>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromPizzaDough(value: PizzaDough): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPizzaDough(value: String): PizzaDough {
        val type = object : TypeToken<PizzaDough>() {}.type
        return gson.fromJson(value, type)
    }
}
