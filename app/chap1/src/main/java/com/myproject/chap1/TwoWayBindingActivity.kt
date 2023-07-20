package com.myproject.chap1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myproject.chap1.databinding.ActivityTwoWayBindingBinding

// 양방향 데이터 결합(Two - Way Binding)
// 데이터와 뷰를 직접 연결해서 서로와 서로에게 영향을 줌 ?

// 1. 기존 방식 -> Activity 에서 View와 연결해서 사용
// 2. 양방향 데이터 결합 방식 -> ViewModel <-> Activity <-> XML

class TwoWayBindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTwoWayBindingBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way_binding)
        setContentView(R.layout.activity_two_way_binding)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.vm = viewModel
        binding.lifecycleOwner = this


    }
}