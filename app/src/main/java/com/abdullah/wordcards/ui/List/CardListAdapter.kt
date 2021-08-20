package com.abdullah.wordcards.ui.List

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.abdullah.wordcards.DataBase.Card

class CardListAdapter(diffCallback : DiffUtil.ItemCallback<Card> ) : ListAdapter<Card, CardViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun addItem(card: Card ):Unit {
        currentList.add(card)
        notifyItemInserted(currentList.size)
    }
    fun removeItem(card:Card):Boolean = currentList.remove(card)


    companion object CardDiff : DiffUtil.ItemCallback<Card>() {
         override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
          return oldItem === newItem
         }

         override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
          return oldItem.id == newItem.id
         }

     }



}