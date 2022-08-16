package com.example.loginapp.ui.activity.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    fun checkUser(user: String, password: String): Boolean {
        Log.e("LoginViewModel", "Pass Here")
        return user == "SISTEMA" && password == "candidato123"
    }
}