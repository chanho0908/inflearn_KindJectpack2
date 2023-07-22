package com.myproject.chap5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myproject.chap5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = this.getPreferences(Context.MODE_PRIVATE)?: return

        binding.save1.setOnClickListener {
            val text = binding.editText1.text.toString()

            with(pref.edit()){
                putString(TestClass.SHARED_VALUE_1, text)
                apply()
            }
        }

        binding.read1.setOnClickListener {
            val value = pref.getString(TestClass.SHARED_VALUE_1, "default value")
            binding.readText1.text = value
        }

    }
}