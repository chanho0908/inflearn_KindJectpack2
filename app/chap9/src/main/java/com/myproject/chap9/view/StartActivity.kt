package com.myproject.chap9.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myproject.chap9.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputBtn.setOnClickListener {
            val text = binding.inputText.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("inputText", text)
            startActivity(intent)
        }
    }
}