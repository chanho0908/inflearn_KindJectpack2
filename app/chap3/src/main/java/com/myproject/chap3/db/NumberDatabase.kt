package com.myproject.chap3.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myproject.chap3.db.dao.NumberDao
import com.myproject.chap3.db.entity.NumberEntity

@Database(entities = [NumberEntity::class], version = 2)
abstract class NumberDatabase:RoomDatabase() {
    abstract fun NumberDao(): NumberDao

    companion object{
        @Volatile
        private var INSTANCE: NumberDatabase ?= null

        fun getDatabase(context: Context): NumberDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NumberDatabase::class.java,
                    "number_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}