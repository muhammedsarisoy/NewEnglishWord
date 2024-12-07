package com.example.myenglishwordworld.ui.wordadd

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.mediarouter.media.RouteListingPreference
import com.example.myenglishwordworld.data.Words
import com.example.myenglishwordworld.data.WordsDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class WordAddRepository(private val wordsDao: WordsDao) {

    suspend fun insertItem(words: Words) {
        wordsDao.insert(words)
    }

    suspend fun saveItem(item: Words) {
        wordsDao.insert(item)
    }

    suspend fun getAllItems(): List<Words> {
        return wordsDao.getAllItems()
    }

    suspend fun deleteItemById(id: Int) {
        wordsDao.deleteItemById(id)
    }

    fun observeAllItems(): Flow<List<Words>> {
        return wordsDao.observeAllItems()
    }

    fun getAllItemsLiveData(): LiveData<List<Words>> {
        return wordsDao.observeAllItems().asLiveData()
    }

    suspend fun getRandomaItem(): Words {
        return wordsDao.getRandomaItem()
    }
}
