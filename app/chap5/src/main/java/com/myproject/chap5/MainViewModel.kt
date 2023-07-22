package com.myproject.chap5

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.myproject.chap5.dataStore.MyDataStore
import kotlinx.coroutines.launch

class MainViewModel(context: Context): ViewModel(){
    private val mDataStore = MyDataStore(context)


    fun insert(userName : String) = viewModelScope.launch {
        mDataStore.insertData(userName)
    }

    val read = mDataStore.getUserName.asLiveData()
}