package com.arlequins.grupo2.ui.splash

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arlequins.grupo2.databinding.ActivityMainBinding
import com.arlequins.grupo2.databinding.ActivitySplashBinding
import com.arlequins.grupo2.ui.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

@SuppressLint("StaticFieldLeak")
private lateinit var splashBinding: ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)


        val timer = Timer()
        timer.schedule(timerTask{
            goToMainActivity()
        }, 1500
        )

    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}