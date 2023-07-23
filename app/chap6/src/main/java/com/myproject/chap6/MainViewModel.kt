package com.myproject.chap6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel() {
    val items: Flow<PagingData<User>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { MyPagingSource() }
    ).flow
    .cachedIn(viewModelScope) // 화면 가로 전환같이 액티비티를 다시 그릴 때 데이터를 유지시켜줌!

}