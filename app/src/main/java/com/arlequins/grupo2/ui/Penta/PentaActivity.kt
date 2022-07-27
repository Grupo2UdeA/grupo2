package com.arlequins.grupo2.ui.Penta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.arlequins.grupo2.databinding.ActivityMainBinding
import com.arlequins.grupo2.databinding.ActivityPentaBinding
import com.arlequins.grupo2.ui.main.MainViewModel

class PentaActivity : AppCompatActivity() {
    private lateinit var mainViewModel: PentaViewModel
    private lateinit var mainBinding: ActivityPentaBinding
    //    private var acum1=0.0
    private var m1spinner="m"
    private var cant1 =0.0
    private var cantA1 =0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityPentaBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        mainViewModel = ViewModelProvider(this).get(PentaViewModel::class.java)
        mainViewModel.resultdata.observe(this) { most ->
            mainBinding.textView2.text = most
        }
        with(mainBinding) {
            button.setOnClickListener {
                m1spinner = spinner.selectedItem.toString()
                val cant = textLado.text.toString()
                val cantA = textApo.text.toString()
                cant1 = cant.toDouble()
                cantA1 = cantA.toDouble()
                mainViewModel.calc(cant1,cantA1,m1spinner)
                //textView.text=imp1.toString()
                //textView.text=m2spinner
            }
        }
    }
}