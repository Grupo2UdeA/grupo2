package com.arlequins.grupo2.ui.triangle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TriangleViewModel: ViewModel() {



    private val mutablePerimeter: MutableLiveData<Int> = MutableLiveData()
    val mutablePerimeterDone: LiveData<Int> = mutablePerimeter

    private val mutableArea: MutableLiveData<Int> = MutableLiveData()
    val mutableAreaDone: LiveData<Int> = mutableArea

    fun calculatePerimeter(base: Int){
        mutablePerimeter.value = base*3
    }

    fun calculateArea(base: Int,altura: Int){
        mutableArea.value = (base*altura)/2
    }


}