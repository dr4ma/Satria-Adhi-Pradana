package com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.markers.DisplayableItem
import com.example.domain.models.FlashSaleModel
import com.example.domain.models.LatestModel
import com.example.satriaadhipradana.databinding.FlashSaleItemRecyclerBinding
import com.example.satriaadhipradana.databinding.LatestItemRecyclerBinding
import com.example.satriaadhipradana.presentation.fragments.details.DetailsFragment
import com.example.satriaadhipradana.presentation.fragments.page1.Page1Fragment
import com.example.satriaadhipradana.utills.downloadIcon

class FlashSaleViewHolder(private val binding : FlashSaleItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root), AdapterViewHolder {

    @SuppressLint("SetTextI18n")
    override fun bind(model: DisplayableItem, position: Int) {
        binding.apply {
            image.downloadIcon((model as FlashSaleModel).image_url)
            price.text = "$ ${model.price}0"
            name.text = model.name
            category.text = model.category
            discount.text = "${model.discount}% off"
        }
        itemView.setOnClickListener {
            Page1Fragment.navigateToDetails(it)
        }
    }
}