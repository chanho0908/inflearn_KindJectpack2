package com.myproject.chap3.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.myproject.chap3.db.entity.NumberEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(number: NumberEntity)

    @Query("SELECT * FROM number_table")
    fun read(): Flow<List<NumberEntity>>

    @Update
    fun update(number: NumberEntity)

    @Delete
    fun delete(number: NumberEntity)

}