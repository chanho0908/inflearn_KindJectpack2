package com.myproject.chap1

import android.service.autofill.Transformation
import androidx.lifecycle.*
import androidx.lifecycle.map

class MainViewModel: ViewModel() {
    var mutableAge = MutableLiveData(0)

    private val _point = MutableLiveData(0)
    val point: LiveData<Int> get() = _point

    //val myPointType: LiveData<MyPointType> = Transformations map(_point)

    fun plus(){
        mutableAge.value = mutableAge.value?.plus(1)
    }

    fun pointPlus(){
        _point.value = _point.value?.plus(10)
    }
}

// 몇가지 타입으로 고정하고 싶을 때 사용
enum class MyPointType{
    BIG,
    MIDDLE,
    SMALL,
    VERY_SMALL
}