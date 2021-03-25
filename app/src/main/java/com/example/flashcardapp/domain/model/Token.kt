package com.example.flashcardapp.domain.model

data class Token(
    val AccessToken : String,
    val AccessTokenExpiration : String,
    val RefreshToken:String,
    val RefreshTokenExpiration : String
) {
}