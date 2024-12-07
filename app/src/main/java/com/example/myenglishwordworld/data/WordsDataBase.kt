package com.example.myenglishwordworld.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executor


@Database(entities = [Words::class], version = 1, exportSchema = false)
abstract class  WordsDataBase : RoomDatabase() {
    abstract fun wordDao(): WordsDao

    companion object{
        @Volatile
        private var Instance: WordsDataBase? = null

        fun getDatabase(context: Context): WordsDataBase {
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context, WordsDataBase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}