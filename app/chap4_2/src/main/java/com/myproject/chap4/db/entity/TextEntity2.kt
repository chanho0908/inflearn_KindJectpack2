package com.myproject.chap4.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_table2")
data class TextEntity2 (

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String,
    @ColumnInfo(name="text2", defaultValue = "this is text2 default")
    val text2 : String,
    val newText:String
)