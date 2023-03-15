package com.example.satriaadhipradana.presentation.fragments.adapterDelegates.viewHolders

import android.view.View
import com.example.domain.markers.DisplayableItem

interface AdapterViewHolder {

    fun bind(model : DisplayableItem, position: Int)
}