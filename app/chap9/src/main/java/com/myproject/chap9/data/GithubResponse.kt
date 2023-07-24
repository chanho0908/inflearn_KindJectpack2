package com.myproject.chap9.data

data class GithubResponse (
    val total_count : Int,
    val incomplete_results : Boolean,
    val items : List<Items>
    )