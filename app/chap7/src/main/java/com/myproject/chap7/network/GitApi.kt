package com.myproject.chap7.network

import com.myproject.chap7.data.GithubResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitApi {
    @GET("users/google/repos")
    suspend fun getData(
        @Query("page") page: Int,
        @Query("per_page") pre_page: Int
    ):Response<GithubResponse>

}