package com.example.flashcardapp.util

import android.content.Context
import android.net.ConnectivityManager
import com.example.flashcardapp.FlashCardApp

class LiveNetworkListener {
    companion object {

        fun isConnected(): Boolean {
            val context = FlashCardApp.getContext()
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val connection = cm.activeNetwork ?: return false
            return true
        }
    }
}