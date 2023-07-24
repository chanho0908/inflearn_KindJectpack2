package com.myproject.chap9.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap9.R
import com.myproject.chap9.databinding.ActivityMainBinding
import com.myproject.chap9.paging.GithubAdapter
import com.myproject.chap9.state.GithubLoadStateAdapter
import com.myproject.chap9.viewModel.MainViewModel
import com.myproject.chap9.viewModel.MainViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var viewModelFactory: MainViewModelFactory
    lateinit var githubAdapter: GithubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        githubAdapter = GithubAdapter()

        loadData(intent.getStringExtra("inputText").toString())

    }

    fun loadData(str: String){
        viewModelFactory = MainViewModelFactory(str)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        val rv = binding.rv

        rv.layoutManager = LinearLayoutManager(this)
        //rv.adapter = githubAdapter
        rv.adapter = githubAdapter.withLoadStateFooter(
            GithubLoadStateAdapter{
                githubAdapter.retry()
            }
        )

        lifecycleScope.launch {
            viewModel.items.collect {
                githubAdapter.submitData(it)
            }
        }
    }
}