package com.myproject.chap7.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val BASIC_URL = "https://api/github/com"

    val client = Retrofit
        .Builder()
        .baseUrl(BASIC_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getInstance(): Retrofit{
        return client
    }
}