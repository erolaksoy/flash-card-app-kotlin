package com.example.flashcardapp.domain.retrofitservices

import com.example.flashcardapp.domain.constants.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{
        fun<T> BuildService(
            baseUrl : String,
            retrofitService:Class<T>,
            existsInterceptor : Boolean
        ) : T {
            val clientBuilder = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            return Retrofit.Builder().baseUrl(ApiConstants.API_BASE_URL).client(clientBuilder.build()).
            addConverterFactory(GsonConverterFactory.create()).build().create(retrofitService)
        }
    }
}