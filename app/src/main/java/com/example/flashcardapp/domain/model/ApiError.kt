package com.example.flashcardapp.domain.model

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("errors")
    val errors : ArrayList<String>,
    @SerializedName("isShow")
    val isShow : Boolean
) {
}