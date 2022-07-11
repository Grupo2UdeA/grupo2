package com.arlequins.grupo2.ui.Penta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PentaViewModel: ViewModel() {
    private var unid=""
    private var perimetro=0.0
    private var area=0.0
    private val result: MutableLiveData<String> = MutableLiveData()
    val resultdata: LiveData<String> = result
    fun calc(x: Double, y: Double, z:String) {
        perimetro=x*6
        area=(perimetro*y)/2
        result.value="Perimetro= "+perimetro.toString()+z+"\n"+"Area= "+area.toString()+z
    }
}