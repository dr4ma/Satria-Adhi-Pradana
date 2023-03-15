package com.example.domain.models

import com.example.domain.markers.DisplayableItem

data class FlashSaleModel(
    val category : String,
    val name : String,
    val price : Double,
    val discount : Int,
    val image_url : String
) : DisplayableItem
