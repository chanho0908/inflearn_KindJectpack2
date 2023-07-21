package com.myproject.chap2.RoomFlowListAdapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap2.R
import com.myproject.chap2.RoomFlowListAdapter.db.UserDatabase
import com.myproject.chap2.RoomFlowListAdapter.db.UserEntity
import com.myproject.chap2.databinding.ActivityMain2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = UserDatabase.getDatabase(this)
        val rv = binding.userRV
        val adapter = UserListAdapter()

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        binding.save.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val name= binding.name.text.toString()
                val age = binding.age.text.toString()
                val userEntity = UserEntity(0,name, age.toInt())

                db.userDao().insert(userEntity)
            }
        }

        binding.get.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().getAllDataAsFlow().collect{

                    // 리스트의 값이 변경될 때 마다 리사이클러뷰의 값 병경
                    withContext(Dispatchers.Main){
                        adapter.submitList(it)
                    }
                }
            }
        }

        binding.next.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }
    }
}