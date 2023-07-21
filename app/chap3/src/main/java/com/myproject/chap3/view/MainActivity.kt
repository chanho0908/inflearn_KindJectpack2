package com.myproject.chap3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap3.MainAdapter
import com.myproject.chap3.R
import com.myproject.chap3.databinding.ActivityMainBinding
import com.myproject.chap3.db.entity.NumberEntity
import com.myproject.chap3.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var numberList: ArrayList<NumberEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.create.setOnClickListener {
            val randNumber = (0..100).random().toString()
            val numberEntity = NumberEntity(0, randNumber)
            viewModel.create(numberEntity)

        }

        val rv = binding.numberRV

        viewModel.read()
        viewModel.list.observe(this){
            numberList = it as ArrayList<NumberEntity>
            val adapter = MainAdapter(it)

            rv.adapter = adapter
            rv.layoutManager = LinearLayoutManager(this)

            onClickEventHandling(adapter)
        }
    }

    private fun onClickEventHandling(adapter: MainAdapter){

        // Update
        adapter.updateClick = object: MainAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                viewModel.update(numberList[position])
            }

        }

        adapter.deleteClick = object : MainAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                viewModel.delete(numberList[position])
            }

        }

    }

}