package com.myproject.chap8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap8.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val myAdapter = MainAdapter()

        binding.rv.adapter = myAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch{
            viewModel.items.collect{
                myAdapter.submitData(it)
            }
        }

        lifecycleScope.launch {
            myAdapter.loadStateFlow.collect{
                val isLoadingNext = it.source.append is LoadState.Loading
                binding.loadingNext.isVisible = isLoadingNext

                val isLoadingPrev = it.source.prepend is LoadState.Loading
                binding.loadingNext.isVisible = isLoadingPrev
            }
        }

        binding.refresh.setOnClickListener {
            myAdapter.refresh()
        }
    }
}