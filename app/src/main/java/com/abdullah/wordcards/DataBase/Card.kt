package com.abdullah.wordcards.DataBase

import androidx.room.*
import java.time.OffsetDateTime

@Entity
data class Card(@PrimaryKey(autoGenerate = true) val id : Int, @ColumnInfo(name = "word") val word : String, @ColumnInfo(name = "translated_word") val Translated : String, @ColumnInfo var timeCreated: OffsetDateTime, @ColumnInfo val isFavorite : Boolean = false , val type : String = "word" ) {

}
