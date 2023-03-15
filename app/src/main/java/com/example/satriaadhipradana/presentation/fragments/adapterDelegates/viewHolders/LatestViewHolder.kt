package com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.markers.DisplayableItem
import com.example.domain.models.LatestModel
import com.example.satriaadhipradana.databinding.LatestItemRecyclerBinding
import com.example.satriaadhipradana.utills.downloadIcon

class LatestViewHolder(private val binding : LatestItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root), AdapterViewHolder {

    @SuppressLint("SetTextI18n")
    override fun bind(model: DisplayableItem, position: Int) {
        binding.apply {
            image.downloadIcon((model as LatestModel).image_url)
            price.text = "$ ${model.price},0"
            name.text = model.name
            category.text = model.category
        }
    }
}