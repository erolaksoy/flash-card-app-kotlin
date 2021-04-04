package com.example.flashcardapp.ui.flashcardmain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcardapp.databinding.FlashCardMainFragmentBinding
import com.example.flashcardapp.domain.model.Card
import com.example.flashcardapp.domain.model.User

class FlashCardMain : Fragment(), OnClickListener {

    companion object {
        fun newInstance() = FlashCardMain()
    }

    private lateinit var viewModel: FlashCardMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FlashCardMainFragmentBinding.inflate(inflater, container, false)
        binding.gridView.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)

        val user = User("asdasd", "pcparticle", "pcparticle@outlook.com")
        val myList = arrayListOf<Card>(
            Card(1, "Aasdasd", "asd", "asd", "as", "asdasd", "asdasd", user),
            Card(2, "Aasdasd", "asd", "asd", "as", "asdasd", "asdasd", user)
        )

        binding.gridView.adapter = GridLayoutAdapter(myList, this)
        return binding.root
    }

    override fun OnClick(item: Card) {
        Toast.makeText(requireContext(), "asdasdasda->>> ${item.Id}", Toast.LENGTH_LONG).show()
    }


}