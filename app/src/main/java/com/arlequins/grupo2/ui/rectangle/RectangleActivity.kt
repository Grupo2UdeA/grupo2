package com.arlequins.grupo2.ui.rectangle

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.R
import com.arlequins.grupo2.databinding.ActivityRectangleBinding

class RectangleActivity : AppCompatActivity() {


    private lateinit var rectangleBinding: ActivityRectangleBinding
    private lateinit var rectangleViewModel: RectangleViewModel

    private var perimeter = 0
    private var area = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rectangleBinding = ActivityRectangleBinding.inflate(layoutInflater)
        val view = rectangleBinding.root
        setContentView(view)

        rectangleViewModel = ViewModelProvider(this)[RectangleViewModel::class.java]

        rectangleViewModel.mutablePerimeterDone.observe(this) { mutablePerimeter ->
            perimeter = mutablePerimeter
        }
        rectangleViewModel.mutableAreaDone.observe(this) { mutableArea ->
            area = mutableArea
        }

        rectangleBinding.textViewResult.visibility = TextView.INVISIBLE

        rectangleBinding.buttonCalculate.setOnClickListener {
            if (rectangleBinding.InputEditTextWidth.text.toString()
                    .isNotEmpty() && rectangleBinding.InputEditTextLength.text.toString().isNotEmpty()
            ) {
                rectangleViewModel.calculatePerimeter(
                    rectangleBinding.InputEditTextWidth.text.toString().toInt(),
                    rectangleBinding.InputEditTextLength.text.toString().toInt()
                )
                rectangleViewModel.calculateArea(
                    rectangleBinding.InputEditTextWidth.text.toString().toInt(),
                    rectangleBinding.InputEditTextLength.text.toString().toInt()
                )
                rectangleBinding.textViewResult.visibility = TextView.VISIBLE
                rectangleBinding.textViewResult.text =
                    getString(R.string.infoRectangle, perimeter.toString(), area.toString())

            } else {
                Toast.makeText(
                    this@RectangleActivity,
                    getString(R.string.emptyInput),
                    Toast.LENGTH_SHORT
                ).show()
                rectangleBinding.textViewResult.visibility = TextView.INVISIBLE
            }
        }
    }
}
//Hola gente