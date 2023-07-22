package com.myproject.chap5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.myproject.chap5.databinding.ActivityMain2Binding
import com.myproject.chap5.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = this.getPreferences(Context.MODE_PRIVATE)?: return

        val util = PreferenceUtils(this)

        binding.putStrBtn.setOnClickListener {
            val text = binding.putStrArea.text.toString()
            util.putStr(KeyList.MY_STR_KEY, text)
        }

        binding.getStrBtn.setOnClickListener {
            val text = util.getStr(KeyList.MY_STR_KEY).toString()
            Log.d("Main2Acitivity", text)
        }

        //Bool

        binding.trueBtn.setOnClickListener {
            util.putBool(KeyList.MY_BOOL_KEY, true)
        }

        binding.falseBtn.setOnClickListener {
            util.putBool(KeyList.MY_BOOL_KEY, false)
        }

        binding.getBoolBtn.setOnClickListener {
            val getData = util.getBool(KeyList.MY_BOOL_KEY)

            Toast.makeText(this, getData.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}