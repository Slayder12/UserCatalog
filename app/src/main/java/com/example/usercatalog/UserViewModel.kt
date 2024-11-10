package com.example.usercatalog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    val userLiveData: MutableLiveData<MutableList<User>> = MutableLiveData(mutableListOf())

}