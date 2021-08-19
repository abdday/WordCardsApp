package com.abdullah.wordcards.DataBase

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class DataBaseHelper(val context : Context) {

        private val Database = Room.databaseBuilder(context , AppDataBase::class.java , "CardDatabase").build()


    fun getDBDao() : CardDao = Database.cardDao()
    }


