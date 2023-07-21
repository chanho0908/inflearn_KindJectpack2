package com.myproject.chap4.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myproject.chap4.db.entity.TextEntity
import com.myproject.chap4.db.entity.TextEntity2

@Dao
interface TextDao2 {

    @Query("SELECT * FROM text_table2")
    fun getAllData() : List<TextEntity2>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity2)

    @Query("DELETE FROM text_table2")
    fun deleteAllData()


}