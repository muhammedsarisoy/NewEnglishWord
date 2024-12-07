package com.example.myenglishwordworld.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Item")
data class Words(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "WordId") val wordId: Int,
    @ColumnInfo(name = "text1") val text1: String,
    @ColumnInfo(name = "text2") val text2: String
)