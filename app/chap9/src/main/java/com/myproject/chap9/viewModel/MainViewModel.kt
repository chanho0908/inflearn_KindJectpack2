package com.myproject.chap9.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.myproject.chap9.data.Items
import com.myproject.chap9.network.GitApi
import com.myproject.chap9.network.RetrofitInstance
import com.myproject.chap9.paging.GithubPagingSource
import kotlinx.coroutines.flow.Flow

class MainViewModel(str: String): ViewModel() {
    private val api = RetrofitInstance.getInstance().create(GitApi::class.java)

    val items : Flow<PagingData<Items>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            GithubPagingSource(api, str)
        }
    )
        .flow
        .cachedIn(viewModelScope)
}