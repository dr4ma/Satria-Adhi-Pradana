package com.example.domain.models

import java.io.Serializable

data class UserModel(
    var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var photoUri: String = ""
) : Serializable
