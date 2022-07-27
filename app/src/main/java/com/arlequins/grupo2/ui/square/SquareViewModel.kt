package com.arlequins.grupo2.ui.square

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData


class SquareViewModel: ViewModel(){
    private var side: Float = 0.0f
    private var area: Float = 0.0f
    private var perimeter: Float = 0.0f
    private var areaStr: String = ""
    private var perimeterStr: String = ""

    private var result1: MutableLiveData<String> = MutableLiveData()
    var resultP: LiveData<String> = result1

    private var result2: MutableLiveData<String> = MutableLiveData()
    var resultA: LiveData<String> = result2

    fun obtainSide(externalSide: String){
        side = externalSide.toFloat()
    }

    private fun calculatePerimeter(){
        perimeter = side*4.0f
    }

    private fun calculateArea(){
        area = side*side
    }

    private fun strResult(){
        areaStr = area.toString()
        perimeterStr = perimeter.toString()
        result1.value = perimeterStr
        result2.value = areaStr
    }

    fun calculateAll(){
        calculateArea()
        calculatePerimeter()
        strResult()
    }
}