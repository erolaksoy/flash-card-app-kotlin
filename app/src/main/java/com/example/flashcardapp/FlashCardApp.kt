package com.example.flashcardapp

import android.app.Application
import timber.log.Timber

class FlashCardApp : Application() {
        override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}