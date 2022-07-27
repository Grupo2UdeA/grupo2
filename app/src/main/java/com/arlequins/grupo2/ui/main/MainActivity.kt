package com.arlequins.grupo2.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.databinding.ActivityMainBinding
import com.arlequins.grupo2.ui.Penta.PentaActivity
import com.arlequins.grupo2.ui.circle.CircleActivity
import com.arlequins.grupo2.ui.rectangle.RectangleActivity
import com.arlequins.grupo2.ui.square.SquareActivity
import com.arlequins.grupo2.ui.triangle.TriangleActivity


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
                if (figure == "Círculo") goToCircle()
                if (figure == "Rectángulo") goToRectangle()
                if (figure == "Pentágono") goToPenta()
                if (figure == "Triángulo") goToTriangle()
            }
        }
    }
    private fun goToCircle() {
        val intent = Intent(this, CircleActivity::class.java)
        startActivity(intent)
    }
    private fun goToSquare() {
        val intent = Intent(this, SquareActivity::class.java)
        startActivity(intent)
    }
    private fun goToPenta() {
        val intent = Intent(this, PentaActivity::class.java)
        startActivity(intent)
    }
    private fun goToRectangle() {
        val intent = Intent(this, RectangleActivity::class.java)
        startActivity(intent)
    }

    private fun goToTriangle() {
        val intent = Intent(this, TriangleActivity::class.java)
        startActivity(intent)
    }

// HOLA mundo
}
