package com.example.flashcardapp.ui.flashcardmain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcardapp.databinding.GridLayoutItemBinding
import com.example.flashcardapp.domain.model.Card

class GridLayoutAdapter(val list: ArrayList<Card>,val listener:OnClickListener) :
    RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GridLayoutItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener.OnClick(item) }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MyViewHolder(private val binding: GridLayoutItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Card) {
        binding.title.text = item.Name
        binding.text.text = item.TargetLanguageText
    }
}

interface OnClickListener {
    fun OnClick(item: Card): Unit
}
