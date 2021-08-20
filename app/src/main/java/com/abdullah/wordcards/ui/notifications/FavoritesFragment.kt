package com.abdullah.wordcards.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdullah.wordcards.R
import com.abdullah.wordcards.databinding.FragmentFavoritesBinding
import com.abdullah.wordcards.ui.List.CardListAdapter

class FavoritesFragment : Fragment() {

    private lateinit var favoritesViewModel: FavoritesViewModel
    private var _binding: FragmentFavoritesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        favoritesViewModel =
                ViewModelProvider(this).get(FavoritesViewModel::class.java)

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val FavoritsListView = binding.lvFavoritesCards

        val myListAdapter =  CardListAdapter(CardListAdapter)
        FavoritsListView.adapter =  myListAdapter
        FavoritsListView.layoutManager = LinearLayoutManager(requireContext())

        favoritesViewModel.favoritesCards.observe(viewLifecycleOwner ,{
            myListAdapter.submitList(it)
        })




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}