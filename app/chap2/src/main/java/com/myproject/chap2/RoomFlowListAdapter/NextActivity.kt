package com.myproject.chap2.RoomFlowListAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap2.R
import com.myproject.chap2.RoomFlowListAdapter.db.UserDatabase
import com.myproject.chap2.databinding.ActivityNextBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = UserDatabase.getDatabase(this)
        val rv = binding.userRV
        val adapter = UserListAdapter()

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        binding.read.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().getAllDataAsFlow().collect{
                    withContext(Dispatchers.Main){
                        adapter.submitList(it)
                    }
                }
            }
        }

        binding.update.setOnClickListener {
            val id = binding.id.text.toString().toInt()
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.userDao().getAllData()
                val userEntity = result[id]
                userEntity.name = "update 된 id"
                userEntity.age = 99999

                db.userDao().update(userEntity)
            }
        }

        binding.remove.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val id = binding.id.text.toString().toInt()
                CoroutineScope(Dispatchers.IO).launch {
                    val result = db.userDao().getAllData()
                    val userEntity = result[id]


                    db.userDao().delete(userEntity)
                }
            }
        }
    }
}