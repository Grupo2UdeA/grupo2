package com.arlequins.grupo2.ui.triangle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.R
import com.arlequins.grupo2.databinding.ActivityTriangleBinding



class TriangleActivity : AppCompatActivity() {

    private lateinit var triangleBinding: ActivityTriangleBinding
    private lateinit var triangleViewModel: TriangleViewModel

    private var perimeter = 0
    private var area = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        triangleBinding = ActivityTriangleBinding.inflate(layoutInflater)
        setContentView(triangleBinding.root)

        triangleViewModel = ViewModelProvider(this)[TriangleViewModel::class.java]

        triangleViewModel.mutablePerimeterDone.observe(this) { mutablePerimeter ->
            perimeter = mutablePerimeter
        }
        triangleViewModel.mutableAreaDone.observe(this) { mutableArea ->
            area = mutableArea
        }

        triangleBinding.textViewResult.visibility = TextView.INVISIBLE

        triangleBinding.buttonCalculate.setOnClickListener {
            if (triangleBinding.InputEditTextBase.text.toString()
                    .isNotEmpty() && triangleBinding.InputEditTextHeight.text.toString().isNotEmpty()
            ) {
                triangleViewModel.calculatePerimeter(
                    triangleBinding.InputEditTextBase.text.toString().toInt()
                )
                triangleViewModel.calculateArea(
                    triangleBinding.InputEditTextBase.text.toString().toInt(),
                    triangleBinding.InputEditTextHeight.text.toString().toInt()
                )
                triangleBinding.textViewResult.visibility = TextView.VISIBLE
                triangleBinding.textViewResult.text =
                    getString(R.string.infoTriangle, perimeter.toString(), area.toString())

            } else {
                Toast.makeText(
                    this@TriangleActivity,
                    getString(R.string.emptyInput),
                    Toast.LENGTH_SHORT
                ).show()
                triangleBinding.textViewResult.visibility = TextView.INVISIBLE
            }
        }


    }
}


