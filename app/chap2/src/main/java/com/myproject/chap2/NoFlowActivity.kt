package com.myproject.chap2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myproject.chap2.databinding.ActivityNoFlowBinding
import com.myproject.chap2.db.TextDatabase
import com.myproject.chap2.db.TextEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// https://medium.com/androiddevelopers/room-flow-273acffe5b57
class NoFlowActivity : AppCompatActivity() {
    lateinit var binding: ActivityNoFlowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDatabase.getDatabase(this)

        binding.insert.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                val text = TextEntity(0, binding.textInputArea.text.toString())
                db.textDao().insert(text)

                binding.textInputArea.setText("")
            }
        }

        /*
        binding.getData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val result = db.textDao().getAllData().toString()

                withContext(Dispatchers.Main){
                    binding.resultArea.text = result
                }


            }
        }*/

        CoroutineScope(Dispatchers.IO).launch {
            db.textDao().getAllData().collect{
                val result = it.toString()

                withContext(Dispatchers.Main){
                    binding.resultArea.text = result
                }
            }
        }

        binding.delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().delete()
            }
        }
    }
}