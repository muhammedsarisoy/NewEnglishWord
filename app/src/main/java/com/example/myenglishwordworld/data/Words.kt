package com.example.myenglishwordworld.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "wordsTable")
data class Words(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "word_id") val wordId: Int,
    @ColumnInfo(name = "english_word") val englishWord: String,
    @ColumnInfo(name = "other_word") val otherWord: String
)