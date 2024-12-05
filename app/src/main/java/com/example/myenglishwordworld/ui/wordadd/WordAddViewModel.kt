package com.example.myenglishwordworld.ui.wordadd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myenglishwordworld.data.Words
import kotlinx.coroutines.launch

class WordAddViewModel(
    private val repository: WordAddRepository

): ViewModel()
{
    fun addWord(word: Words , englishWord: String, otherWord: String) {
        viewModelScope.launch {
            repository.addWordToRoom(word)
        }
    }

    suspend fun getAllWordsFromRoom(): List<Words> {
        return repository.getAllWordsFromRoom()
    }

    suspend fun getWordByIdFromRoom(wordId: Int): Words? {
        return repository.getWordByIdFromRoom(wordId)
    }

    suspend fun getWordByEnglishWordFromRoom(englishWord: String): Words? {
        return repository.getWordByEnglishWordFromRoom(englishWord)
    }

    suspend fun getWordByOtherWordFromRoom(otherWord: String): Words? {
        return repository.getWordByOtherWordFromRoom(otherWord)
    }

    suspend fun deleteWordByIdFromRoom(wordId: Int) {
        repository.deleteWordByIdFromRoom(wordId)
    }



}