package com.myproject.chap8

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.myproject.chap8.model.Data
import com.myproject.chap8.network.PassengerApi
import com.myproject.chap8.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class MainViewModel: ViewModel() {

    private val api = RetrofitInstance.getInstance().create(PassengerApi::class.java)

    val items: Flow<PagingData<Data>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = {
            MyPagingSource(api)
        }
    ).flow
        .cachedIn(viewModelScope)


}