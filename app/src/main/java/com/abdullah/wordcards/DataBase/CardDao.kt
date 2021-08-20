package com.abdullah.wordcards.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface CardDao {

    @Query("SELECT * FROM card")
    fun getAll() : LiveData<List<Card>>


    @Query("SELECT * FROM card WHERE isFavorite = 1")
    fun getAllFavorites() : LiveData<List<Card>>

    @Query("SELECT * FROM Card WHERE id = :id")
    fun getCard(id : Int) : Card

    @Insert
    fun insertNewCard(card : Card)

    @Update
    fun updateCard(card : Card)

    @Delete
    fun deleteCard(card : Card)

}