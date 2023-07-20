package com.myproject.chap2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TextEntity::class], version = 1)
abstract class TextDatabase : RoomDatabase() {

    abstract fun textDao() : TextDAO

    companion object {

        // 값을 메인 메모리에만 저장하는 어노테이션
        @Volatile
        private var INSTANCE : TextDatabase? = null

        fun getDatabase(context : Context) : TextDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }

        }

    }

}