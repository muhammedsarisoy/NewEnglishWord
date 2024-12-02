package com.example.myenglishwordworld.data

import androidx.room.Dao
import androidx.room.Query


@Dao
interface WordsDao {

    @Query("SELECT * FROM words")
    suspend fun getAll(): List<Words>

    @Query("SELECT * FROM words WHERE word_id = :wordId")
    suspend fun getWordById(wordId: Int): Words?

    @Query("SELECT * FROM words WHERE english_word = :englishWord")
    suspend fun getWordByEnglishWord(englishWord: String): Words?

    @Query("SELECT * FROM words WHERE other_word = :otherWord")
    suspend fun getWordByOtherWord(otherWord: String): Words?

}