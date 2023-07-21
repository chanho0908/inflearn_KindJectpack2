package com.myproject.chap4.db

import android.content.Context
import android.util.Log
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.myproject.chap4.db.dao.TextDao
import com.myproject.chap4.db.dao.TextDao2
import com.myproject.chap4.db.dao.TextDao3
import com.myproject.chap4.db.entity.ImageConverter
import com.myproject.chap4.db.entity.MyConverters
import com.myproject.chap4.db.entity.TextEntity
import com.myproject.chap4.db.entity.TextEntity2
import com.myproject.chap4.db.entity.TextEntity3

@Database(entities = [TextEntity::class, TextEntity2::class, TextEntity3::class], version = 4,
    autoMigrations = [
   AutoMigration(from = 3, to= 4)
    ]
)

@TypeConverters(MyConverters::class, ImageConverter::class)
abstract class TextDatabase : RoomDatabase(){

    abstract fun textDao() : TextDao
    abstract fun textDao2() : TextDao2
    abstract fun textDao3() : TextDao3

    companion object {

        @Volatile
        private var INSTANCE : TextDatabase? = null

        fun getDatabase(
            context: Context
        ) : TextDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                )
                    //.fallbackToDestructiveMigration()
                    //.addMigrations(MIGRATION1_2)
                    //.addMigrations(MIGRATION2_3)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        val MIGRATION1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                Log.d("migrate", "MIGRATION_1_2")
                database.execSQL("CREATE TABLE `text_table2` " +
                        "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `text2` TEXT NOT NULL)")
            }

        }

        val MIGRATION2_3 = object : Migration(2, 3){
            override fun migrate(database: SupportSQLiteDatabase) {
                Log.d("migrate", "MIGRATION_2_3")
                database.execSQL("ALTER TABLE `text_table2` ADD COLUMN " +
                        "`newText` TEXT NOT NULL DEFAULT `newnew`")
            }

        }
    }


}