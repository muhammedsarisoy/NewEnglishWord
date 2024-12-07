package com.example.myenglishwordworld.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface WordsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(words: Words)

    @Query("SELECT * FROM Item")
    suspend fun getAllItems(): List<Words>

    @Query("DELETE FROM Item WHERE wordId = :id")
    suspend fun deleteItemById(id: Int)

    @Query("SELECT * FROM Item")
    abstract fun observeAllItems(): Flow<List<Words>>

    @Query("SELECT * FROM Item ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomaItem(): Words {
        val allItems = getAllItems()
        return allItems.random()
    }
}