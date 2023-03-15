package com.example.domain.models

import com.example.domain.markers.DisplayableItem

data class CategoryModel(
    val icon: Int,
    val label: String
) : DisplayableItem
