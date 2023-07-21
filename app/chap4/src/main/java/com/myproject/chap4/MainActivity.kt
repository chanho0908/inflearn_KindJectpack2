package com.myproject.chap4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.myproject.chap4.databinding.ActivityMainBinding
import com.myproject.chap4.db.TextDatabase
import com.myproject.chap4.db.entity.TextEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDatabase.getDatabase(this)

        binding.insert.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(TextEntity(0, binding.textInputArea.text.toString()))
                binding.textInputArea.setText("")
            }

        }

        binding.getData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("MAIN", db.textDao().getAllData().toString())
            }
        }

        binding.delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
            }
        }
    }
}