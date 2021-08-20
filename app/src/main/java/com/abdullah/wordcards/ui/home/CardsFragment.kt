package com.abdullah.wordcards.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdullah.wordcards.databinding.FragmentCardsBinding
import com.abdullah.wordcards.ui.List.CardListAdapter

class CardsFragment : Fragment() {

    private lateinit var cardsViewModel: CardsViewModel
    private var _binding: FragmentCardsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        cardsViewModel =
                ViewModelProvider(this).get(CardsViewModel::class.java)

        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val RL_view = binding.lvCards

        val myListAdapter =  CardListAdapter(CardListAdapter.CardDiff)
        RL_view.adapter =  myListAdapter
        RL_view.layoutManager = LinearLayoutManager(requireContext())

        cardsViewModel._cards.observe(viewLifecycleOwner , {
            myListAdapter.submitList(it)
        })
/*
        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

 */
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}