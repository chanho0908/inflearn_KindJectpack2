package com.myproject.chap1

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("myAge")
fun myAgeSetting(view: TextView, age: Int){
    if (age > 20){
        view.text = "${age} 보다 많음"
    }else{
        view.text = "${age}"
    }
}

@BindingAdapter("myImg")
fun myImageSetting(view: ImageView, age: Int){
    if (age > 20){
        view.setImageResource(R.drawable.bok)
    }
}