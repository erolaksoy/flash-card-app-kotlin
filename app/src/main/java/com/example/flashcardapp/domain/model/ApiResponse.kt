package com.example.flashcardapp.domain.model

data class ApiResponse<T>(
    val data:T?=null,
    val statusCode:Int,
    val error: ApiError?=null,
    val isSuccess:Boolean

) {
}