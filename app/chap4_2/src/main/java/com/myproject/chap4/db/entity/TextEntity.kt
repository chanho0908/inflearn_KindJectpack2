package com.myproject.chap4.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_table")
data class TextEntity (

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String

)