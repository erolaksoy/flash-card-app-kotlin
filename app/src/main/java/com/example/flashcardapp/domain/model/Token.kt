package com.example.flashcardapp.domain.model

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("accessToken")
    val AccessToken : String,
    @SerializedName("accessTokenExpiration")
    val AccessTokenExpiration : String,
    @SerializedName("refreshToken")
    val RefreshToken:String,
    @SerializedName("refreshTokenExpiration")
    val RefreshTokenExpiration : String
) {
}