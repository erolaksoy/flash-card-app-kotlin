package com.example.flashcardapp.domain.retrofitservices

import com.example.flashcardapp.domain.model.ApiResponse
import com.example.flashcardapp.domain.model.Card
import retrofit2.Response
import retrofit2.http.*

interface RetrofitCardService {
    @GET("/api/flashcards/")
    suspend fun getAllCards() : Response<ApiResponse<ArrayList<Card>>>

    @POST("/api/flashcards/")
    suspend fun addCard(@Body flashCard : Card) : Response<ApiResponse<Card>>

    @GET("/api/flashcards/{cardId}")
    suspend fun getCardById(@Path("cardId") cardId : Int) : Response<ApiResponse<Card>>

    @PUT("api/flashcards/{cardId}/")
    suspend fun updateCard(@Path("cardId") cardId : Int, @Body flashCard: Card) : Response<ApiResponse<Card>>

    @DELETE("/api/flashcards/{cardId}")
    suspend fun deleteCard(@Path("cardId") cardId: Int) : Response<ApiResponse<Unit>>
}