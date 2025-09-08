package com.uv.androidassessment.data.api

import com.uv.androidassessment.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("data.json")
    suspend fun getUser(): Response<UserResponse>
}
