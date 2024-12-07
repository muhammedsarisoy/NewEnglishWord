package com.example.myenglishwordworld.ui.wordadd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WordAddViewModelFactory(private val repository: WordAddRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordAddViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordAddViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}