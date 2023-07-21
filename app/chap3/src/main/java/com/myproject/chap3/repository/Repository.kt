package com.myproject.chap3.repository

import com.myproject.chap3.App
import com.myproject.chap3.db.NumberDatabase
import com.myproject.chap3.db.entity.NumberEntity

class Repository {

    private val context = App.context()
    private val db = NumberDatabase.getDatabase(context)

    fun create(numberEntity: NumberEntity) = db.NumberDao().create(numberEntity)

    fun read() = db.NumberDao().read()

    fun update(numberEntity: NumberEntity) = db.NumberDao().update(numberEntity)

    fun delete(numberEntity: NumberEntity) = db.NumberDao().delete(numberEntity)
}