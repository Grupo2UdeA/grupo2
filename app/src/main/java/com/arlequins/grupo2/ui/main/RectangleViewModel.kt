package com.arlequins.grupo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RectangleViewModel : ViewModel() {

    private val mutablePerimeter: MutableLiveData<Int> = MutableLiveData()
    val mutablePerimeterDone: LiveData<Int> = mutablePerimeter

    private val mutableArea: MutableLiveData<Int> = MutableLiveData()
    val mutableAreaDone: LiveData<Int> = mutableArea


    fun calculatePerimeter(width: Int,length: Int){
        mutablePerimeter.value = 2*width + 2*length
    }

    fun calculateArea(width: Int,length: Int){
        mutableArea.value = width*length
    }
}