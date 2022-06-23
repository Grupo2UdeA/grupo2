package com.arlequins.grupo2.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.databinding.ActivityMainBinding
import com.arlequins.grupo2.ui.square.SquareActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContentView(view)

        with(mainBinding){
            sendButton.setOnClickListener {
                val figure = figursSpinner.selectedItem.toString()
                if (figure == "Cuadrado") goToSquare()
            }
        }
    }


    private fun goToSquare() {
        val intent = Intent(this, SquareActivity::class.java)
        startActivity(intent)
    }
// HOLA mundo
}
