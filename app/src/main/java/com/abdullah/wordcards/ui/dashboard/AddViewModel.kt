package com.abdullah.wordcards.ui.dashboard

import android.app.Application
import androidx.lifecycle.*
import com.abdullah.wordcards.DataBase.AppDataBase
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(application: Application) : AndroidViewModel(application) {

    private  var cardRepo =  CardRepo(application)
    //private  val  db =  AppDataBase.getDatabase(application).cardDao()





}