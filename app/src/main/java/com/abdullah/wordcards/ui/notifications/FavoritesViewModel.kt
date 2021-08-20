package com.abdullah.wordcards.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val cardRepo: CardRepo = CardRepo(application)
     val favoritesCards: LiveData<List<Card>> = cardRepo.favoritesCards

}