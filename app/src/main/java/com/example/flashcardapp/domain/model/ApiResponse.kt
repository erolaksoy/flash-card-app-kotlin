package com.example.flashcardapp.domain.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("data")
    val data:T?=null,
    @SerializedName("statusCode")
    val statusCode:Int,
    @SerializedName("error")
    val error: ApiError?=null,
    val isSuccess:Boolean
) {
}