package com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.markers.DisplayableItem
import com.example.domain.models.FlashSaleModel
import com.example.domain.models.LatestModel
import com.example.satriaadhipradana.databinding.FlashSaleItemRecyclerBinding
import com.example.satriaadhipradana.databinding.LatestItemRecyclerBinding
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders.FlashSaleViewHolder
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders.LatestViewHolder
import com.example.satriaadhipradana.presentation.fragments.page1.Page1Fragment
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import javax.inject.Inject

class FlashSaleAdapterDelegate @Inject constructor() : AdapterDelegate<List<DisplayableItem>>(){

    override fun isForViewType(items: List<DisplayableItem>, position: Int): Boolean {
        return items[position] is FlashSaleModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = FlashSaleItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FlashSaleViewHolder(binding)
    }

    override fun onBindViewHolder(
        items: List<DisplayableItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        val item = items[position] as FlashSaleModel
        (holder as FlashSaleViewHolder).bind(item, position)
    }
}