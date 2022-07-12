package com.arlequins.grupo2.ui.circle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class CircleViewModel: ViewModel() {

    private var radio: Float = 0.0f
    private var pi: Float = 3.1416f
    private var area: Float = 0.0f
    private var perimeter : Float = 0.0f
    private var areaString : String = ""
    private var perimeterString : String = ""

    private var result1: MutableLiveData<String> = MutableLiveData()
    var result2: LiveData<String> = result1

    fun obtainRadio(radios: Float) {
        radio = radios
    }

    fun calculateArea(){
        area = radio * radio * pi
    }

    fun calculatePerimeter(){
        perimeter = 2 * pi * radio
    }

    private fun convToString(){
        perimeterString = perimeter.toString()
        areaString = area.toString()
    }

    fun showResults(){
        convToString()
        result1.value = "Area: $areaString\nPerimetro: $perimeterString"
    }
}