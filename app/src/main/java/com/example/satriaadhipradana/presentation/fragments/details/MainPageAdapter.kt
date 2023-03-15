package com.example.satriaadhipradana.presentation.fragments.details

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.satriaadhipradana.databinding.ItemImageDetailsBinding
import com.example.satriaadhipradana.utills.downloadIcon

class MainPageAdapter : RecyclerView.Adapter<MainPageAdapter.ImagesDetailHolder>() {

    private var listImages = mutableListOf<String>()

    inner class ImagesDetailHolder(private val binding: ItemImageDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(item: String) {
            with(binding) {
                imageDetails.downloadIcon(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesDetailHolder {
        val binding = ItemImageDetailsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImagesDetailHolder(binding)
    }

    override fun onBindViewHolder(holder: ImagesDetailHolder, position: Int) {
        holder.bind(listImages[position])
    }

    override fun getItemCount(): Int {
        return listImages.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(newList: MutableList<String>) {
        listImages = newList
        notifyDataSetChanged()
    }
}