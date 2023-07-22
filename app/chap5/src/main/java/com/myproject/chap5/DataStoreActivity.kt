package com.myproject.chap5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.myproject.chap5.databinding.ActivityDataStoreBinding

class DataStoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataStoreBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save1.setOnClickListener {
            val text = binding.editText1.text.toString()
            viewModel.insert(text)
        }

        binding.read1.setOnClickListener {
            val text = viewModel.read.toString()

            binding.readText1.text = text
        }

    }
}