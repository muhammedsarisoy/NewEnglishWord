package com.example.myenglishwordworld.ui.mywordscreen

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.myenglishwordworld.data.Words
import com.example.myenglishwordworld.data.WordsDataBase
import com.example.myenglishwordworld.ui.wordadd.WordAddRepository

class MyWordScreenViewModel(
    context: Context
): ViewModel() {

    val database = WordsDataBase.getDatabase(context)
    val wordDao = database.wordDao()

    val repository = WordAddRepository(wordDao)


}