package com.uv.androidassessment.data.repository

import com.uv.androidassessment.data.api.RetrofitInstance
import com.uv.androidassessment.data.model.UserResponse

class UserRepository {
    suspend fun getUser(): UserResponse? {
        val response = RetrofitInstance.api.getUser()
        return if (response.isSuccessful) response.body() else null
    }
}
