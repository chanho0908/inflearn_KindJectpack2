package com.myproject.chap2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import com.myproject.chap2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CatListAdapter()

        val rv = binding.catRV
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        adapter.submitList(firstSetUpData())

        Handler(Looper.getMainLooper()).postDelayed({
            adapter.submitList(secondSetUpData())
        }, 3000)


    }

    fun firstSetUpData(): ArrayList<CatDataModel>{
        val cat1 = CatDataModel(1, "cat1", 10)
        val cat2 = CatDataModel(2, "cat2", 11)
        val cat3 = CatDataModel(3, "cat3", 12)
        val cat4 = CatDataModel(4, "cat4", 13)
        val cat5 = CatDataModel(5, "cat5", 14)

        val arr1 = ArrayList<CatDataModel>()
        arr1.add(cat1)
        arr1.add(cat2)
        arr1.add(cat3)
        arr1.add(cat4)
        arr1.add(cat5)

        return arr1
    }

    fun secondSetUpData(): ArrayList<CatDataModel>{

        val cat3 = CatDataModel(3, "cat3", 12)
        val cat4 = CatDataModel(4, "cat4", 13)
        val cat5 = CatDataModel(5, "cat5", 14)
        val cat6 = CatDataModel(6, "cat6", 16)
        val cat7 = CatDataModel(7, "cat7", 17)
        val cat8 = CatDataModel(8, "cat8", 18)

        val arr1 = ArrayList<CatDataModel>()
        arr1.add(cat3)
        arr1.add(cat4)
        arr1.add(cat5)
        arr1.add(cat6)
        arr1.add(cat7)
        arr1.add(cat8)

        return arr1
    }
}