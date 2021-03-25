package com.example.flashcardapp.domain.model

data class Card(
    val Id : Int,
    val Name : String,
    val MotherLanguageText : String,
    val TargetLanguageText : String,
    val Caption : String,
    val PhotoPath : String?=null,
    val AppUserId: Int,
    val AppUser : User
){

}
