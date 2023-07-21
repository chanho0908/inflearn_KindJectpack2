package com.myproject.chap3.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_table")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var randomNumber: String
)
