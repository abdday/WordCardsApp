package com.abdullah.wordcards.ui.List

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdullah.wordcards.DataBase.AppDataBase
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo
import com.abdullah.wordcards.R
import java.time.OffsetDateTime

class CardViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val wordView = view.findViewById<TextView>(R.id.tv_word)
    private val TranslatedView = view.findViewById<TextView>(R.id.tv_translated)
    private val removeBtnView = view.findViewById<ImageButton>(R.id.btn_remove)
    private val FavoriteBtnView = view.findViewById<ImageButton>(R.id.btn_favorite)
    private val db = CardRepo(view.context)
    fun bind(card :Card): Unit{
        wordView.text = card.word
        TranslatedView.text = card.Translated
        removeBtnView.setOnClickListener({
            db.deleteCard(card)
        })


        FavoriteBtnView.setImageResource( if(card.isFavorite) R.drawable.ic_star_filld else R.drawable.ic_star_border )


        FavoriteBtnView.setOnClickListener({
           db.changeCard(Card(card.id , card.word , card.Translated , OffsetDateTime.now() ,!card.isFavorite))
        })

    }

    companion object creator{
        fun create(parent : ViewGroup) : CardViewHolder{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view , parent ,false)
            return CardViewHolder(view)
        }
    }



}