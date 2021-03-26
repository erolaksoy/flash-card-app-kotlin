package com.example.flashcardapp.domain.services

import com.example.flashcardapp.domain.constants.ApiConstants
import com.example.flashcardapp.domain.model.ApiResponse
import com.example.flashcardapp.domain.model.Card
import com.example.flashcardapp.domain.retrofitservices.ApiClient
import com.example.flashcardapp.domain.retrofitservices.RetrofitCardService
import com.example.flashcardapp.domain.util.HelperService
import retrofit2.Response
import timber.log.Timber

class CardService {
    companion object {
        private val retrofitService =
            ApiClient.BuildService(ApiConstants.API_BASE_URL, RetrofitCardService::class.java, true)

        suspend fun getCategoryList(): ApiResponse<ArrayList<Card>> {
            println("buraya girdi")
            val result = retrofitService.getAllCards()
            if (!result.isSuccessful) return HelperService.handleApiError<ApiResponse<ArrayList<Card>>,ArrayList<Card>>(result) //result-> generalResponse : Response<>
            val data = result.body() as ArrayList<Card>
            return ApiResponse(data,200,null,true)
        }
    }
}