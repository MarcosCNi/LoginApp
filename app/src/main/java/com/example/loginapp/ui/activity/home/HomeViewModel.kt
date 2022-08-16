package com.example.loginapp.ui.activity.home

import androidx.lifecycle.ViewModel
import com.example.loginapp.db.DataBaseHelper
import com.example.loginapp.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val db: DataBaseHelper
) : ViewModel() {

    fun save(userModel: UserModel){
        db.addUser(userModel)
    }
}