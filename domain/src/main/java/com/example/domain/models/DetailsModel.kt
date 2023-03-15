package com.example.domain.models

import com.example.domain.markers.DisplayableItem

data class DetailsModel(
    val name : String,
    val description : String,
    val rating : Double,
    val number_of_reviews : Int,
    val price : Double,
    val colors : MutableList<String>,
    val image_urls : MutableList<String>
) : DisplayableItem