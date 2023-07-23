package com.myproject.chap7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.myproject.chap7.data.GithubResponseItem
import com.myproject.chap7.network.GitApi
import com.myproject.chap7.network.RetrofitInstance
import com.myproject.chap7.paging.MyPagingSource
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel()  {
    private val api = RetrofitInstance.getInstance().create(GitApi::class.java)

    val items: Flow<PagingData<GithubResponseItem>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { MyPagingSource(api) }
    ).flow
        .cachedIn(viewModelScope)
}