package com.example.myenglishwordworld.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "words")
data class Words(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "word_id") @NotNull var word_id : Int,
    @ColumnInfo(name = "english_word") @NotNull var english_word : String,
    @ColumnInfo(name = "other_word") @NotNull var other_word : String,
){

}
