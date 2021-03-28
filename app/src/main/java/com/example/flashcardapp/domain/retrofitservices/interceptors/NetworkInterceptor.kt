package com.example.flashcardapp.domain.retrofitservices.interceptors

import com.example.flashcardapp.FlashCardApp
import com.example.flashcardapp.domain.util.OfflineException
import com.example.flashcardapp.util.LiveNetworkListener
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!LiveNetworkListener.isConnected()) throw OfflineException("Offline!")
        val request = chain.request()
        return chain.proceed(request)
    }
}