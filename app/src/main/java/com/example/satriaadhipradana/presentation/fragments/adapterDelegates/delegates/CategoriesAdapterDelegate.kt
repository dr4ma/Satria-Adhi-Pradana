package com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.markers.DisplayableItem
import com.example.domain.models.CategoryModel
import com.example.domain.models.FlashSaleModel
import com.example.domain.models.LatestModel
import com.example.satriaadhipradana.databinding.CategoryItemRecyclerBinding
import com.example.satriaadhipradana.databinding.FlashSaleItemRecyclerBinding
import com.example.satriaadhipradana.databinding.LatestItemRecyclerBinding
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders.CategoriesViewHolder
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders.FlashSaleViewHolder
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders.LatestViewHolder
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import javax.inject.Inject

class CategoriesAdapterDelegate @Inject constructor() : AdapterDelegate<List<DisplayableItem>>(){

    override fun isForViewType(items: List<DisplayableItem>, position: Int): Boolean {
        return items[position] is CategoryModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = CategoryItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoriesViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(
        items: List<DisplayableItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val item = items[position] as CategoryModel
        (holder as CategoriesViewHolder).bind(item, position)
    }
}