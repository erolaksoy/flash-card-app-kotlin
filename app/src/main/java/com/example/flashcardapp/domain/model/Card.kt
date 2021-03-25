package com.example.flashcardapp.domain.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("Id")
    val Id : Int,
    @SerializedName("Name")
    val Name : String,
    @SerializedName("MotherLanguageText")
    val MotherLanguageText : String,
    @SerializedName("TargetLanguageText")
    val TargetLanguageText : String,
    @SerializedName("Caption")
    val Caption : String,
    @SerializedName("PhotoPath")
    val PhotoPath : String?=null,
    @SerializedName("AppUserId")
    val AppUserId: Int,
    @SerializedName("AppUser")
    val AppUser : User
){

}
