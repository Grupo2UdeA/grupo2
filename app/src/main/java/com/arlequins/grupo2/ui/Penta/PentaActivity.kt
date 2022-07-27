package com.arlequins.grupo2.ui.Penta

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.R
import com.arlequins.grupo2.databinding.ActivityPentaBinding

class PentaActivity : AppCompatActivity() {
    private lateinit var pentaViewModel: PentaViewModel
    private lateinit var pentaBinding: ActivityPentaBinding

    //    private var acum1=0.0
    private var m1spinner = "m"
    private var cant1 = 0.0
    private var cantA1 = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pentaBinding = ActivityPentaBinding.inflate(layoutInflater)
        val view = pentaBinding.root
        setContentView(view)
        pentaViewModel = ViewModelProvider(this).get(PentaViewModel::class.java)
        pentaViewModel.resultdata.observe(this) { most ->
            pentaBinding.textView2.text = most
        }
        pentaBinding.textView2.visibility = TextView.INVISIBLE
        with(pentaBinding) {
            button.setOnClickListener {
                if (textLado.text.toString().isNotEmpty() && textApo.text.toString().isNotEmpty()) {
                    m1spinner = spinner.selectedItem.toString()
                    val cant = textLado.text.toString()
                    val cantA = textApo.text.toString()
                    cant1 = cant.toDouble()
                    cantA1 = cantA.toDouble()
                    pentaViewModel.calc(cant1, cantA1, m1spinner)
                    //textView.text=imp1.toString()
                    //textView.text=m2spinner
                    pentaBinding.textView2.visibility = TextView.VISIBLE

                } else {
                    Toast.makeText(
                        this@PentaActivity,
                        getString(R.string.emptyInput),
                        Toast.LENGTH_SHORT
                    ).show()
                    pentaBinding.textView2.visibility = TextView.INVISIBLE


                }
            }
        }
    }
}