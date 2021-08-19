package com.abdullah.wordcards.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = arrayOf(Card::class) , version = 1 ,exportSchema = false)
@TypeConverters(TimeTypeConverters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun cardDao() : CardDao

    companion object DB{
        private val DATABASE_NAME = "AppDataBase"
        @Volatile
        private var  INSTANCE : AppDataBase? = null

        private const val NUMBER_OF_THREADS = 4
        val databaseWriteExecutor : ExecutorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        fun getDatabase(context: Context): AppDataBase {
            val tempInstance = INSTANCE
            if(INSTANCE != null)
                return tempInstance!!

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext ,  AppDataBase::class.java , DATABASE_NAME).build()
                INSTANCE = instance
                return instance
            }


        }


    }




}