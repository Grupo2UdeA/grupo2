package com.arlequins.grupo2.ui.square

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arlequins.grupo2.databinding.ActivitySquareBinding


@SuppressLint("StaticFieldLeak")
private lateinit var squareBinding: ActivitySquareBinding

class SquareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        squareBinding = ActivitySquareBinding.inflate(layoutInflater)
        val view = squareBinding.root
        setContentView(view)

        with(squareBinding){
            calculateButton.setOnClickListener{
                val side = sideSquareInputText.text.toString().toFloat()
                val perimeter = side*4
                val area = side*side

                answerPerimeterTextView.text = perimeter.toString()
                answerAreaTextView.text = area.toString()
            }
        }
    }
}