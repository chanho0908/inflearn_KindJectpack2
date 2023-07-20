package com.myproject.chap2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TextDAO {
    @Query("SELECT * FROM TEXT_TABLE")
    //fun getAllData(): List<TextEntity>
    fun getAllData(): Flow<List<TextEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity)

    @Query("DELETE FROM TEXT_TABLE")
    fun delete()
}