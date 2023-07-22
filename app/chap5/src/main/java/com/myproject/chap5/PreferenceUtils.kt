package com.myproject.chap5

import android.content.Context

class PreferenceUtils(context: Context) {
    private val pref = context.getSharedPreferences("my_pref", Context.MODE_PRIVATE)

    fun putStr(key:String, value: String){
        with(pref.edit()){
            putString(key, value)
            apply()
        }
    }

    fun getStr(key: String): String?{
        return pref.getString(key, "default")
    }

    fun putBool(key:String, value: Boolean){
        with(pref.edit()){
            putBoolean(key, value)
            apply()
        }
    }

    fun getBool(key: String): Boolean{
        return pref.getBoolean(key, false)
    }
}