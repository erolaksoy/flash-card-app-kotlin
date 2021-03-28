package com.example.flashcardapp.ui.launch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flashcardapp.R
import com.example.flashcardapp.domain.model.UserSignin
import com.example.flashcardapp.domain.services.TokenService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val user = UserSignin("pcparticleS@outlook.com", "Password12*")
        GlobalScope.launch {
            TokenService.signInUser(user)
        }

    }
}