package com.myproject.chap7

import MyAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap7.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val myAdapter = MyAdapter()

        binding.rv.adapter = myAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            viewModel.items.collect {
                myAdapter.submitData(it)
            }
        }
    }
}