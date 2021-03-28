package com.example.flashcardapp.domain.retrofitservices

import com.example.flashcardapp.domain.model.ApiResponse
import com.example.flashcardapp.domain.model.Token
import com.example.flashcardapp.domain.model.UserSignin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitTokenService {

    @POST("api/auth/CreateToken")
    suspend fun userSignIn(@Body userSignIn : UserSignin) : Response<ApiResponse<Token>>

    @POST("api/auth/CreateTokenByRefreshToken")
    suspend fun createTokenByRefreshToken(@Body refreshToken : String) : Response<ApiResponse<Token>>


}