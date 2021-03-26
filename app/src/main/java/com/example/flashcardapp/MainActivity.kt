package com.example.flashcardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcardapp.domain.model.Card
import com.example.flashcardapp.domain.services.CardService
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch {
            val service = CardService.getCategoryList()
            println(service.data)
        }


    }
}