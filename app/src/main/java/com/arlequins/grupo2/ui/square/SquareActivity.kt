package com.arlequins.grupo2.ui.square

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
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

        squareViewModel.resultP.observe(this){
            squareBinding.answerPerimeterTextView.text = it
        }

        squareViewModel.resultA.observe(this){
            squareBinding.answerAreaTextView.text = it
        }

        with(squareBinding){
            calculateButton.setOnClickListener{
                squareViewModel.obtainSide(sideSquareInputText.text.toString())
                squareViewModel.calculateAll()
            }
        }
    }
}


