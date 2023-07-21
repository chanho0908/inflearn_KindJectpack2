package com.myproject.chap4.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myproject.chap4.db.entity.TextEntity
import com.myproject.chap4.db.entity.TextEntity2
import com.myproject.chap4.db.entity.TextEntity3

@Dao
interface TextDao3 {

    @Query("SELECT * FROM text_table3")
    fun getAllData() : List<TextEntity3>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity3)

    @Query("DELETE FROM text_table3")
    fun deleteAllData()


}