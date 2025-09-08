package com.uv.androidassessment.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uv.androidassessment.data.model.User
import com.uv.androidassessment.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val repository = UserRepository()
    val userData = MutableLiveData<User?>()

    fun fetchUser() {
        viewModelScope.launch {
            val response = repository.getUser()
            userData.postValue(response?.user)
        }
    }
}
