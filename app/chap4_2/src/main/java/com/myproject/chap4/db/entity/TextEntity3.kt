package com.myproject.chap4.db.entity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.io.ByteArrayOutputStream
import java.util.Date

@Entity(tableName = "text_table3")
data class TextEntity3 (

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String,
    @ColumnInfo(name = "photo")
    val myPhoto : Bitmap
)

class MyConverters {

    @TypeConverter
    fun fromTimestampToDate(value : Long) : Date {
        return Date(value)
    }

    @TypeConverter
    fun fromDateToTimestamp(date : Date) : Long {
        return date.time
    }

}

class ImageConverter{
    @TypeConverter
    fun fromBitmapToByteArray(bitmap: Bitmap): ByteArray{
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun fromByteArrayToBitmap(byteArray: ByteArray): Bitmap{
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}