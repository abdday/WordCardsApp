package com.abdullah.wordcards.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo

class CardsViewModel(application: Application) : AndroidViewModel(application) {

    private  var cardRepo: CardRepo
    //private  val  db =  AppDataBase.getDatabase(application).cardDao()
    val _cards : LiveData<List<Card>>

    init {
        cardRepo = CardRepo(application)
        _cards = cardRepo.cards
    }


    /*
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
*/
}
