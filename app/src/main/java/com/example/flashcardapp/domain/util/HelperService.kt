package com.example.flashcardapp.domain.util

import com.example.flashcardapp.domain.model.ApiError
import com.example.flashcardapp.domain.model.ApiResponse
import com.google.gson.Gson
import retrofit2.Response
import timber.log.Timber

class HelperService {
    companion object{
        fun<T1,T2> handleApiError(generalResponse: Response<T1>) : ApiResponse<T2>{
            var apiError :ApiError?=null
            if(generalResponse.errorBody()!=null){
                val errorBody = generalResponse.errorBody()!!.string()
                apiError = Gson().fromJson(errorBody,ApiError::class.java)
                Timber.d("ApiError ${apiError.toString()}")
            }
            return ApiResponse<T2>(isSuccess = false,data = null,error = apiError, statusCode = generalResponse.code())
        }

        fun<T1,T2> convert(value : T1) : List<T2>{
            val list = listOf<T2>()
            return list
        }

        fun<T> handleException(ex : Exception) : ApiResponse<T>{
            return when(ex){
                is OfflineException->{
                    val exMessage = arrayListOf("Connection time out! Please check to the connection!")
                    Timber.d("Error/${exMessage[0]}")
                    val apiError = ApiError(exMessage,true)
                    ApiResponse(null,500,apiError,false)
                }
                else ->{
                    val exMessage = arrayListOf("An error occurred. Please try again!")
                    Timber.d("Error/${exMessage[0]}")
                    val apiError = ApiError(exMessage,true)
                    ApiResponse(null,500,apiError,false)
                }
            }
        }
    }
}