package com.example.flashcardapp.util

import android.content.Context
import android.net.ConnectivityManager

class LiveNetworkListener {
    companion object {
        fun isConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val connection = cm.activeNetwork ?: return false
            return true
        }
    }
}