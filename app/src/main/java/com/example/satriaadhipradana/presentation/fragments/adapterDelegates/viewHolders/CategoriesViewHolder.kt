package com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.markers.DisplayableItem
import com.example.domain.models.CategoryModel
import com.example.domain.models.FlashSaleModel
import com.example.domain.models.LatestModel
import com.example.satriaadhipradana.databinding.CategoryItemRecyclerBinding
import com.example.satriaadhipradana.databinding.FlashSaleItemRecyclerBinding
import com.example.satriaadhipradana.databinding.LatestItemRecyclerBinding
import com.example.satriaadhipradana.utills.downloadIcon

class CategoriesViewHolder(
    private val binding: CategoryItemRecyclerBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root), AdapterViewHolder {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bind(model: DisplayableItem, position: Int) {
        with(binding) {
            iconCategory.setImageDrawable(
                context.resources.getDrawable(
                    (model as CategoryModel).icon,
                    context.theme
                )
            )
            textCategory.text = model.label
        }
    }
}