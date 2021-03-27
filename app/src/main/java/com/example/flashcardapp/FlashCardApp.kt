package com.example.flashcardapp

import android.app.Application
import android.content.Context
import timber.log.Timber

class FlashCardApp : Application() {

    companion object {
        //TODO:change with context using bestpractice
        private lateinit var contextInstance: Context // there will be a memory leak, wrong code
        fun getContext(): Context {
            return contextInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        contextInstance = this.applicationContext
        Timber.plant(Timber.DebugTree())
    }

}

