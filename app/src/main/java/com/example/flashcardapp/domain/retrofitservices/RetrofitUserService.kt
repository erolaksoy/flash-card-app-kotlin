package com.example.flashcardapp.domain.retrofitservices

import com.example.flashcardapp.domain.model.ApiResponse
import com.example.flashcardapp.domain.model.User
import com.example.flashcardapp.domain.model.UserSignUp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitUserService {
    @POST("/api/users/")
    suspend fun createUser(@Body user : UserSignUp) : Response<ApiResponse<User>>

    @GET("/api/users/")
    suspend fun getUser() : Response<ApiResponse<User>>
}