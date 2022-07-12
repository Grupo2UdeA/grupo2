package com.arlequins.grupo2.ui.square

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.R
import com.arlequins.grupo2.databinding.ActivitySquareBinding


@SuppressLint("StaticFieldLeak")
private lateinit var squareBinding: ActivitySquareBinding
private lateinit var squareViewModel: SquareViewModel

class SquareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        squareBinding = ActivitySquareBinding.inflate(layoutInflater)
        val view = squareBinding.root
        setContentView(view)


        squareViewModel = ViewModelProvider(this)[SquareViewModel::class.java]
        setContentView(view)

        squareViewModel.resultP.observe(this) {
            squareBinding.answerPerimeterTextView.text = it
        }

        squareViewModel.resultA.observe(this) {
            squareBinding.answerAreaTextView.text = it
        }
        squareBinding.answerAreaTextView.visibility = TextView.VISIBLE
        squareBinding.answerPerimeterTextView.visibility = TextView.VISIBLE

        with(squareBinding) {
            calculateButton.setOnClickListener {
                if (squareBinding.sideSquareInputText.text.toString()
                        .isNotEmpty()
                ) {
                    squareViewModel.obtainSide(sideSquareInputText.text.toString())
                    squareViewModel.calculateAll()
                    squareBinding.answerAreaTextView.visibility = TextView.VISIBLE
                    squareBinding.answerPerimeterTextView.visibility = TextView.VISIBLE
                } else {
                    Toast.makeText(
                        this@SquareActivity,
                        getString(R.string.emptyInput),
                        Toast.LENGTH_SHORT
                    ).show()
                    squareBinding.answerAreaTextView.visibility = TextView.INVISIBLE
                    squareBinding.answerPerimeterTextView.visibility = TextView.INVISIBLE


                }

            }
        }
    }
}


