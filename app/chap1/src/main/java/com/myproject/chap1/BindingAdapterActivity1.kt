package com.myproject.chap1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myproject.chap1.databinding.ActivityBindingAdapter1Binding

// 양방향 데이터 결합! / BindingAdapter
class BindingAdapterActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityBindingAdapter1Binding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_adapter1)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.vm = viewModel
        binding.lifecycleOwner = this
    }
}