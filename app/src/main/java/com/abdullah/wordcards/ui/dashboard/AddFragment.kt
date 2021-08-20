package com.abdullah.wordcards.ui.dashboard

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abdullah.wordcards.DataBase.Card
import com.abdullah.wordcards.DataBase.CardRepo
import com.abdullah.wordcards.R
import com.abdullah.wordcards.databinding.FragmentAddBinding
import java.time.OffsetDateTime

class AddFragment : Fragment() {

    private lateinit var wordView : EditText
    private lateinit var TranslatedView : EditText
    private lateinit var addBtnView : Button
    private lateinit var favoriteCheckboxView : CheckBox

    private lateinit var addViewModel: AddViewModel
    private var _binding: FragmentAddBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        addViewModel  = ViewModelProvider(this).get(AddViewModel::class.java)

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

          bindViews()
          setOnAddBtnClicked()

//            wordView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->  addViewModel.tanslated.value = wordView.text.toString(); true })
//
        addViewModel.word.observe(viewLifecycleOwner , {
            wordView.setText(it)
        })


        return root
    }

    fun bindViews() {
        wordView = binding.editTextWord
        TranslatedView = binding.editTextTranslated
        addBtnView = binding.btnAdd
        favoriteCheckboxView = binding.checkBoxFavorite
    }

    fun setOnAddBtnClicked(){
        addBtnView.setOnClickListener({
           val word = wordView.text.toString()
           val translated = TranslatedView.text.toString()
           val favoritechecked = favoriteCheckboxView.isChecked
           val stringCheck =  checkEmptyStrings(word,translated)
            if(!stringCheck)
                Toast.makeText(requireContext(), resources.getString(R.string.add_error_meesage) , Toast.LENGTH_SHORT).show()
            else{
                 val cardRepo = CardRepo(requireContext())
                cardRepo.addCard( Card( 0 ,word ,translated , OffsetDateTime.now() , favoritechecked))
                Toast.makeText(requireContext(), resources.getString(R.string.add_succecful_meesage) , Toast.LENGTH_SHORT).show()

                // reset values
                resetvalues()
            }
        })
    }

    fun resetvalues(){
        wordView.setText("")
      TranslatedView.setText("")
         favoriteCheckboxView.isChecked =false
        addViewModel.word.value = ""
        addViewModel.tanslated.value = ""
    }


    fun checkEmptyStrings(vararg strings : String): Boolean{
        for(string in strings )
            if(TextUtils.isEmpty(string))
                return false

        return true
    }

    override fun onStop() {
        super.onStop()
        addViewModel.word.value = wordView.text.toString()
        addViewModel.tanslated.value = TranslatedView.text.toString()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}