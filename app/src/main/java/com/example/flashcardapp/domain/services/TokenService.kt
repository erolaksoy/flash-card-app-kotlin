package com.example.flashcardapp.domain.services

import com.example.flashcardapp.domain.constants.ApiConstants
import com.example.flashcardapp.domain.model.ApiResponse
import com.example.flashcardapp.domain.model.Token
import com.example.flashcardapp.domain.model.UserSignin
import com.example.flashcardapp.domain.retrofitservices.ApiClient
import com.example.flashcardapp.domain.retrofitservices.RetrofitTokenService
import com.example.flashcardapp.domain.util.HelperService
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception

class TokenService {
    companion object {
        private val retrofitService = ApiClient.BuildService(
            ApiConstants.API_BASE_URL,
            RetrofitTokenService::class.java,
            false
        )

        suspend fun signInUser(user: UserSignin): ApiResponse<Token> {
            try {
//                Timber.d("Logging in!!")
//                val response = retrofitService.userSignIn(user)
//                println(response.body())
//                if(!response.isSuccessful) return HelperService.handleResponseError(response)
//                Timber.i("signInUser response data : ${response.body()!!}")
//                if (response.body()!!.error != null) return HelperService.handleApiError(response.body()!!)
//                val data = response.body()!!.data as Token
//                return ApiResponse(data,response.code(),null,true)
                val response = retrofitService.userSignIn(user)
                Timber.i("signInUser response data : ${response.body()!!}")
                return HelperService.handleAllStates<ApiResponse<Token>, Token>(response)

            } catch (ex: Exception) {

                return HelperService.handleException(ex)
            }
        }

        suspend fun createTokenByRefreshToken(refreshToken: String): ApiResponse<Token> {
            return try {
                val response = retrofitService.createTokenByRefreshToken(refreshToken)
                HelperService.handleAllStates<ApiResponse<Token>, Token>(response)
            } catch (ex: Exception) {
                HelperService.handleException(ex)
            }
        }
    }
}