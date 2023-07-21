package com.myproject.chap4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import com.myproject.chap4.databinding.ActivityMainBinding
import com.myproject.chap4.db.TextDatabase
import com.myproject.chap4.db.entity.TextEntity
import com.myproject.chap4.db.entity.TextEntity2
import com.myproject.chap4.db.entity.TextEntity3
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDatabase.getDatabase(this)

        binding.insert.setOnClickListener {
            /*
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(TextEntity(0, binding.textInputArea.text.toString()))
                db.textDao2().insert(TextEntity2
                    (0, binding.textInputArea.text.toString(), "this", "is new"))
                binding.textInputArea.setText("")
            }*/



        }

        binding.getData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("MAIN", db.textDao().getAllData().toString())
                Log.d("MAIN", db.textDao2().getAllData().toString())
            }
        }

        binding.delete.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAllData()
                db.textDao2().deleteAllData()
            }
        }

        binding.setImage.setOnClickListener {
            val drawable = binding.bok1.drawable
            val bitmap = drawable.toBitmap()

            CoroutineScope(Dispatchers.IO).launch {
                db.textDao3().insert(TextEntity3(0, "tmpText", bitmap))
            }
        }

        val bok2 = findViewById<ImageView>(R.id.bok2)

        val getImage = findViewById<Button>(R.id.getImage)
        getImage.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {

                val result = db.textDao3().getAllData()

                withContext(Dispatchers.Main) {
                    bok2.setImageBitmap(result[0].myPhoto)
                }



            }
        }

    }
}