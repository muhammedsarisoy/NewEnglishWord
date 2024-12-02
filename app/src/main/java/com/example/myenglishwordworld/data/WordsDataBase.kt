package com.example.myenglishwordworld.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.Executor


@Database(entities = [Words::class], version = 1)
abstract class WordsDataBase: RoomDatabase() {
    abstract val wordsDao: WordsDao

    companion object {
        var INSTANCE: WordsDataBase? = null

        fun getInstance(context: Context, executor: Executor): WordsDataBase? {
            if (INSTANCE == null) {
                synchronized(WordsDataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        WordsDataBase::class.java,
                        "database.db"
                    ).createFromAsset("database.db").build()
                }
            }
            return INSTANCE
        }
    }
}