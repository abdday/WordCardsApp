package com.abdullah.wordcards.ui.dashboard

import android.app.Application
import androidx.lifecycle.*
import com.abdullah.wordcards.DataBase.AppDataBase
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel() : ViewModel() {

    val word : MutableLiveData<String> = MutableLiveData()
    val tanslated : MutableLiveData<String> = MutableLiveData()


}