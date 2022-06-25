package com.arlequins.grupo2.ui.circle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.databinding.ActivityCircleBinding

class CircleActivity : AppCompatActivity() {
    private lateinit var circleBinding: ActivityCircleBinding
    private lateinit var circleViewModel: CircleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        circleBinding = ActivityCircleBinding.inflate(layoutInflater)
        val view = circleBinding.root

        circleViewModel = ViewModelProvider(this).get(CircleViewModel::class.java)
        setContentView(view)

        circleViewModel.result2.observe(this){
            circleBinding.results.text = it
        }

        with(circleBinding){
            calculate.setOnClickListener{
                circleViewModel.obtainRadio(inputRadioEditTextNumber.text.toString().toFloat())
                circleViewModel.calculateArea()
                circleViewModel.calculatePerimeter()
                circleViewModel.showResults()
            }
        }
    }


}