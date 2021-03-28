package com.example.flashcardapp.domain.services

import com.example.flashcardapp.domain.constants.ApiConstants
import com.example.flashcardapp.domain.model.ApiResponse
import com.example.flashcardapp.domain.model.Card
import com.example.flashcardapp.domain.retrofitservices.ApiClient
import com.example.flashcardapp.domain.retrofitservices.RetrofitCardService
import com.example.flashcardapp.domain.util.HelperService
import timber.log.Timber

class CardService {
    companion object {
        private val retrofitService =
            ApiClient.BuildService(ApiConstants.API_BASE_URL, RetrofitCardService::class.java, true)

        suspend fun getCategoryList(): ApiResponse<ArrayList<Card>> {
            try {
                val response = retrofitService.getAllCards()
                if (!response.isSuccessful) return HelperService.handleResponseError<ApiResponse<ArrayList<Card>>, ArrayList<Card>>(
                    response
                ) //result-> generalResponse : Response<>
                if (response.body()!!.error != null) return HelperService.handleApiError(response.body()!!)
                val data = response.body()!!.data as ArrayList<Card>
                return ApiResponse(data, 200, null, true)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }

        suspend fun addCard(card: Card): ApiResponse<Card> {
            try {
                Timber.d("CardService AddCard op.")
                val response = retrofitService.addCard(card)
                if (!response.isSuccessful) return HelperService.handleResponseError(response)
                if (response.body()!!.error != null) return HelperService.handleApiError(response.body()!!)
                val data = response.body()!!.data as Card
                return ApiResponse(data, response.body()!!.statusCode, null, true)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }

        suspend fun getCardById(id: Int): ApiResponse<Card> {
            try {
                val response = retrofitService.getCardById(id)
                if (!response.isSuccessful) return HelperService.handleResponseError(response)
                if (response.body()!!.error != null) return HelperService.handleApiError(response.body()!!)
                val data = response.body()!!.data as Card
                return ApiResponse(data, response.body()!!.statusCode, null, true)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }

        suspend fun updateCard(id: Int, card: Card): ApiResponse<Card> {
            try {
                val response = retrofitService.updateCard(id, card)
                if (!response.isSuccessful) return HelperService.handleResponseError(response)
                if (response.body()!!.error != null) return HelperService.handleApiError(response.body()!!)
                val data = response.body()!!.data as Card
                return ApiResponse(data, response.body()!!.statusCode, null, true)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }

        suspend fun deleteCard(id: Int): ApiResponse<Unit> {
            try {
                val response = retrofitService.deleteCard(id)
                if (!response.isSuccessful) return HelperService.handleResponseError(response)
                if (response.body()!!.error != null) return HelperService.handleApiError(response.body()!!)
                return ApiResponse(null, response.body()!!.statusCode, null, true)
            } catch (ex: Exception) {
                return HelperService.handleException(ex)
            }
        }

    }
}