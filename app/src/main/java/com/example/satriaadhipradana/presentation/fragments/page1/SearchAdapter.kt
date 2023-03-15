package com.example.satriaadhipradana.presentation.fragments.page1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.satriaadhipradana.databinding.SearchItemStyleBinding

class SearchAdapter() : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var mListWords = mutableListOf<String>()

    inner class SearchViewHolder(private val binding: SearchItemStyleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: String) {
            with(binding) {
                textSearch.text = item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchItemStyleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mListWords.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(mListWords[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: MutableList<String>) {
        mListWords = newList
        notifyDataSetChanged()
    }
}