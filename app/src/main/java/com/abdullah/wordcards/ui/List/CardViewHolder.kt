package com.abdullah.wordcards.ui.List

import android.animation.AnimatorInflater
import android.content.res.Resources
import android.text.Annotation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.view.animation.Animation
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.abdullah.wordcards.DataBase.AppDataBase
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo
import com.abdullah.wordcards.R
import java.time.OffsetDateTime

class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val wordView = view.findViewById<TextView>(R.id.tv_word)
    private val TranslatedView = view.findViewById<TextView>(R.id.tv_translated)
    private val removeBtnView = view.findViewById<ImageButton>(R.id.btn_remove)
    private val FavoriteBtnView = view.findViewById<ImageButton>(R.id.btn_favorite)
    private val buttons_layout = view.findViewById<LinearLayout>(R.id.buttons_layout)
    private val card = view.findViewById<CardView>(R.id.card)

    private val db = CardRepo(view.context)

    init {
        view.setOnClickListener({
           //  val rotate =  RotateAnimation(0f , 180f,Animation.RELATIVE_TO_SELF , 0.5f , RELATIVE_TO_SELF ,0.5f)
         //   val rotate = AnimationUtils.loadAnimation( view.context,R.animator.card_filp_animator)

            var animationResource : Int = 0

            if(TranslatedView.visibility == View.INVISIBLE ) {
                TranslatedView.visibility = View.VISIBLE
                animationResource = R.animator.card_filp_animator
            }
            else {
                TranslatedView.visibility = View.INVISIBLE
                animationResource = R.animator.card_filp_animator2
            }


            val cardRotator =
                AnimatorInflater.loadAnimator(view.context, animationResource)
            cardRotator.setTarget(card)
            cardRotator.start()
            val textRotator1 =
                AnimatorInflater.loadAnimator(view.context, animationResource)
            val textRotator2 =
                AnimatorInflater.loadAnimator(view.context, animationResource)
            val textRotator3 =
                AnimatorInflater.loadAnimator(view.context, animationResource)
            textRotator1.setTarget(wordView)
            textRotator2.setTarget(TranslatedView)
            textRotator3.setTarget(buttons_layout)

            textRotator1.start()
            textRotator2.start()
            textRotator3.start()


        })
    }



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