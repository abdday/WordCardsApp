package com.abdullah.wordcards.ui.dashboard

import android.app.Application
import androidx.lifecycle.*
import com.abdullah.wordcards.DataBase.AppDataBase
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private  var cardRepo: CardRepo
    //private  val  db =  AppDataBase.getDatabase(application).cardDao()
      val _cards : LiveData<List<Card>>

    init {
        cardRepo = CardRepo(application)

        _cards = cardRepo.cards
    }

    private var _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    fun readData(){
//        val db = AppDataBase.getDatabase( getApplication()).cardDao()
//        _text.value = db.getAll().value!!.get(0).word
//      //  AppDataBase.databaseWriteExecutor.execute( { })
      if( _cards.value != null)
       _text.value = _cards.value!![0].word

     //   _cards.asFlow()

       // viewModelScope.launch(Dispatchers.IO) {  _text.value =  cardRepo.getCard().value!![0].word }



       // _cards.value!![0].also { _text.value = it.word }
    }

    // we do that in order not to be able to change the value form outside this class!!
    val text: LiveData<String> = _text
}