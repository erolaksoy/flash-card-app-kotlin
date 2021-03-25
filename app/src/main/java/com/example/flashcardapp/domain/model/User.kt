package com.example.flashcardapp.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("Id")
    val Id : String,
    @SerializedName("UserName")
    val UserName : String,
    @SerializedName("Email")
    val Email: String,

)
