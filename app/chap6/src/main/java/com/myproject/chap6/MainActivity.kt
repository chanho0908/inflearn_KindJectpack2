package com.myproject.chap6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap6.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// MainActivity -> ViewModel -> PagingSource -> Repository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myAdapter = MyAdapter()

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = myAdapter

        lifecycleScope.launch {
            viewModel.items.collect{
                myAdapter.submitData(it)
            }
        }
    }
}