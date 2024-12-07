package com.example.myenglishwordworld.ui.wordadd

import android.media.RouteListingPreference
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myenglishwordworld.data.Words
import kotlinx.coroutines.launch

class WordAddViewModel(private val repository: WordAddRepository) : ViewModel() {

    fun saveItem(words: Words) {
        viewModelScope.launch {
            repository.saveItem(words)
        }
    }

    fun deleteItemById(id: Int) {
        viewModelScope.launch {
            repository.deleteItemById(id)
        }
    }

    private fun fetchWords() {
        viewModelScope.launch {
            val words = repository.getAllItems()
        }
    }

    fun getAllItemsLiveData(): LiveData<List<Words>> {
        return repository.getAllItemsLiveData()
    }

    suspend fun getRandomaItem(): Words {
        return repository.getRandomaItem()
    }
}

