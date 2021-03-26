package com.example.flashcardapp.domain.model

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("id")
    val Id : Int,
    @SerializedName("name")
    val Name : String,
    @SerializedName("motherLanguageText")
    val MotherLanguageText : String,
    @SerializedName("targetLanguageText")
    val TargetLanguageText : String,
    @SerializedName("caption")
    val Caption : String,
    @SerializedName("photoPath")
    val PhotoPath : String?=null,
    @SerializedName("appUserId")
    val AppUserId: String,
    @SerializedName("appUser")
    val AppUser : User
){

}
