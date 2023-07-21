package com.myproject.chap3.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.myproject.chap3.db.entity.NumberEntity
import com.myproject.chap3.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repo = Repository()
    lateinit var list: LiveData<List<NumberEntity>>

    fun create(numberEntity: NumberEntity) = viewModelScope.launch(Dispatchers.IO){
        repo.create(numberEntity)
    }

    fun read(){
        list = repo.read().asLiveData()
    }

    fun update(numberEntity: NumberEntity)= viewModelScope.launch(Dispatchers.IO){
        val randNum = (0..100).random().toString()
        numberEntity.randomNumber = "updated: $randNum"

        repo.update(numberEntity)
    }

    fun delete(numberEntity: NumberEntity)= viewModelScope.launch(Dispatchers.IO){
        repo.delete(numberEntity)
    }
}