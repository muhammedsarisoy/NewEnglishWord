package com.example.myenglishwordworld.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface WordsDao {

    @Query("SELECT * FROM wordstable")
    suspend fun getAll(): List<Words>

    @Query("SELECT * FROM wordstable WHERE word_id = :wordId")
    suspend fun getWordById(wordId: Int): Words?

    @Query("SELECT * FROM wordstable WHERE english_word = :englishWord")
    suspend fun getWordByEnglishWord(englishWord: String): Words?

    @Query("SELECT * FROM wordstable WHERE other_word = :otherWord")
    suspend fun getWordByOtherWord(otherWord: String): Words?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Words)

    @Query("DELETE FROM wordstable WHERE word_id = :wordId")
    suspend fun deleteWordById(wordId: Int)

}