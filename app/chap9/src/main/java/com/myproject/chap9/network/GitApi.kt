package com.myproject.chap9.network

import com.myproject.chap9.data.GithubResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitApi {

    @GET("search/repositories")
    suspend fun getData(
        @Query("q") query : String,
        @Query("page") page : Int,
        @Query("per_page") per_page : Int,
    ) : GithubResponse
}