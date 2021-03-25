package com.example.flashcardapp.domain.model

data class ApiError(
    val errors : ArrayList<String>,
    val isShow : Boolean
) {
}