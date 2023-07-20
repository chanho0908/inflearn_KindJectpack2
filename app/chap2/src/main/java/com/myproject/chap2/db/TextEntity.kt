package com.myproject.chap2.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "text_table")
data class TextEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var text: String,
)