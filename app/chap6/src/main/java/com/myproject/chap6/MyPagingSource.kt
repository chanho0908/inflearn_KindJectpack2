package com.myproject.chap6

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay

private const val STARTING_KEY = 1

class MyPagingSource: PagingSource<Int, User>() {

    init {
        Log.d("MyPagingSource", "init")
    }

    // 새로고침을 누르면 어떻게 할 것인지?
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }

    // Paging이 실행되면 어떻게 처리할 것인가
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        Log.d("MyPagingSource", "load")
        Log.d("MyPagingSource", params.loadSize.toString())
        Log.d("MyPagingSource", params.key.toString())

        // key에 따리 값을 얼마나 뿌려줄 것인가
        val page = params.key ?: STARTING_KEY

        // 1부터 시작해서 30*3
        val range = page.until(page + params.loadSize)

        if (page != STARTING_KEY) delay(3000)

        return LoadResult.Page(
            data = range.map { num->
                User(id = num, userName = "UserNumber is $num")
            },
            prevKey = null,
            nextKey = range.last + 1

        )
    }
}