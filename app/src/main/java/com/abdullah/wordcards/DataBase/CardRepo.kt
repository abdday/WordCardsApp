package com.abdullah.wordcards.DataBase

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData

class CardRepo(context: Context) {
    private  var  cardDao :CardDao = AppDataBase.getDatabase(context).cardDao()
     val cards:  LiveData<List<Card>> =  cardDao.getAll()
    val favoritesCards  = cardDao.getAllFavorites()


    fun addCard( card: Card) :Unit{
        Log.i("meeee" , "added")
        AppDataBase.databaseWriteExecutor.execute( { cardDao.insertNewCard(card) })
    }

    fun deleteCard(card: Card){
        AppDataBase.databaseWriteExecutor.execute( { cardDao.deleteCard(card) })

    }


    fun changeCard(card: Card){
        AppDataBase.databaseWriteExecutor.execute( { cardDao.updateCard(card) })

    }



}
