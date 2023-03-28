package com.example.midterm2.Data

import com.example.midterm2.domain.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("api/?inc=nat,name,email&results=10")
    suspend fun getUsers(): Response<UserResponse>
}