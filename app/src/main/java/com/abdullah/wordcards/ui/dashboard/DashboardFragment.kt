package com.abdullah.wordcards.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.abdullah.wordcards.DataBase.AppDataBase
import com.abdullah.wordcards.R
import com.abdullah.wordcards.databinding.FragmentAddBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        dashboardViewModel  = ViewModelProvider(this).get(DashboardViewModel::class.java)

      //  val Database = Room.databaseBuilder( requireContext(), AppDataBase::class.java , "CardDatabase").build()
       // dashboardViewModel.db = Database.cardDao()


        ///dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard

        val showBtnView = binding.dashBtnShow

        val wordTextView = binding.dashTvWord





        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}