package com.example.satriaadhipradana.presentation.fragments.adapterDelegates

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.markers.DisplayableItem
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates.CategoriesAdapterDelegate
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates.FlashSaleAdapterDelegate
import com.example.satriaadhipradana.presentation.fragments.adapterDelegates.delegates.LatestAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import javax.inject.Inject

class MainAdapter @Inject constructor(
    latestAdapterDelegate: LatestAdapterDelegate,
    flashSaleAdapterDelegate: FlashSaleAdapterDelegate,
    categoriesAdapterDelegate: CategoriesAdapterDelegate
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val delegatesManager = AdapterDelegatesManager<List<DisplayableItem>>()
    private var items = listOf<DisplayableItem>()

    init {
        delegatesManager.addDelegate(latestAdapterDelegate)
        delegatesManager.addDelegate(flashSaleAdapterDelegate)
        delegatesManager.addDelegate(categoriesAdapterDelegate)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(items, position, holder)
    }

    fun setItems(newItems: List<DisplayableItem>, onSuccess: () -> Unit) {
        items = newItems
        onSuccess()
    }
}