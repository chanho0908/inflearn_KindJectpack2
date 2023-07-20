package com.myproject.chap1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myproject.chap1.databinding.ActivityTwoWayAndBingAdapterBinding

class TwoWayAndBingAdapterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoWayAndBingAdapterBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_and_bing_adapter)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.vm = viewModel
        binding.lifecycleOwner = this


    }
}