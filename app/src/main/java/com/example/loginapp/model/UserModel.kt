package com.example.loginapp.model

data class UserModel(
    var code: String? = null,
    var name: String,
    var cpf: String,
    var address: String? = null,
    var phone: String? = null
)
