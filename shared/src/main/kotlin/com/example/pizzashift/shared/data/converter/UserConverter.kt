package com.example.pizzashift.shared.data.converter

import com.example.pizzashift.shared.data.model.UserDTO
import com.example.pizzashift.shared.domain.model.User

fun UserDTO.toDomainModel(): User {

    return User(
        phone = this.phone,
        firstname = this.firstname,
        lastname = this.lastname,
        middlename = this.middlename,
        email = this.email,
        city = this.city
    )
}