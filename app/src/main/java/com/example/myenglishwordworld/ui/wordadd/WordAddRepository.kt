package com.example.myenglishwordworld.ui.wordadd

import com.example.myenglishwordworld.data.Words
import com.example.myenglishwordworld.data.WordsDao

class WordAddRepository(
    private val wordsDao: WordsDao

) {

    suspend fun addWordToRoom(word: Words) {
        wordsDao.insertWord(word)
    }

    suspend fun getAllWordsFromRoom(): List<Words> {
        return wordsDao.getAll()
    }

    suspend fun getWordByIdFromRoom(wordId: Int): Words? {
        return wordsDao.getWordById(wordId)
    }

    suspend fun getWordByEnglishWordFromRoom(englishWord: String): Words? {
        return wordsDao.getWordByEnglishWord(englishWord)
    }

    suspend fun getWordByOtherWordFromRoom(otherWord: String): Words? {
        return wordsDao.getWordByOtherWord(otherWord)
    }

    suspend fun deleteWordByIdFromRoom(wordId: Int) {
        wordsDao.deleteWordById(wordId)
    }

}