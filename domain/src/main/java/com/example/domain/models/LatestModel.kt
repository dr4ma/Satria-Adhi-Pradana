package com.example.domain.models

import com.example.domain.markers.DisplayableItem

data class LatestModel(
    val category : String,
    val name : String,
    val price : Double,
    val image_url : String
) : DisplayableItem
