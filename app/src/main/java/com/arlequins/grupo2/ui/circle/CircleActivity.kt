package com.arlequins.grupo2.ui.circle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.R
import com.arlequins.grupo2.databinding.ActivityCircleBinding

class CircleActivity : AppCompatActivity() {
    private lateinit var circleBinding: ActivityCircleBinding
    private lateinit var circleViewModel: CircleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        circleBinding = ActivityCircleBinding.inflate(layoutInflater)
        val view = circleBinding.root

        circleViewModel = ViewModelProvider(this)[CircleViewModel::class.java]
        setContentView(view)

        circleViewModel.result2.observe(this){
            circleBinding.results.text = it
        }
        circleBinding.results.visibility = TextView.VISIBLE


        circleBinding.calculate.setOnClickListener{
                if (circleBinding.inputRadioEditTextNumber.text.toString().isNotEmpty())
                {
                    circleViewModel.obtainRadio(circleBinding.inputRadioEditTextNumber.text.toString().toFloat())
                    circleViewModel.calculateArea()
                    circleViewModel.calculatePerimeter()
                    circleViewModel.showResults()
                    circleBinding.results.visibility = TextView.VISIBLE
                }
                else {
                    Toast.makeText(
                        this,
                        getString(R.string.emptyInput),
                        Toast.LENGTH_SHORT
                    ).show()
                    circleBinding.results.visibility = TextView.INVISIBLE
                }
            }
        }



}