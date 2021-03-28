package com.example.flashcardapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcardapp.R
import com.example.flashcardapp.domain.model.UserSignin
import com.example.flashcardapp.domain.services.TokenService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }
}