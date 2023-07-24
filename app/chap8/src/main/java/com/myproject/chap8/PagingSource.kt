package com.myproject.chap8

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.myproject.chap8.model.Data
import com.myproject.chap8.network.PassengerApi

private const val STATING_KEY = 1

class MyPagingSource (
    private val passengerApi : PassengerApi
) : PagingSource<Int, Data>(){
    // 새로고침
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        // 최근에 접근한 index
        val anchorPosition = state.anchorPosition
        return anchorPosition?.let { 
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val page = params.key ?: STATING_KEY

        val response = passengerApi.getData(page, params.loadSize)

        val data = response.body()?.data

        if (data !=null){
            return LoadResult.Page(
                data = listOf(),
                prevKey = null,
                nextKey = null
            )
        }else{
            return LoadResult.Page(
                data = listOf(),
                prevKey = if (page == 1) null else page -1,
                nextKey = page + (params.loadSize / 30)
            )
        }
    }


}