package com.arlequins.grupo2.ui.Circle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arlequins.grupo2.databinding.ActivityCircleBinding


private lateinit var circleBinding: ActivityCircleBinding

class CircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        circleBinding = ActivityCircleBinding.inflate(layoutInflater)
        val view = circleBinding.root
        setContentView(view)

        with(circleBinding){
            calculate.setOnClickListener{
                val radio = inputRadioEditTextNumber.text.toString().toFloat()
                val area = 3.1416 * radio * radio
                val perimeter = 2 * 3.1416 * radio

                val answerArea = area.toString()
                val answerPerimeter = perimeter.toString()

                results.text = "Area: " + answerArea + "\n" + "Perimetro: " + answerPerimeter
            }
        }
    }
}