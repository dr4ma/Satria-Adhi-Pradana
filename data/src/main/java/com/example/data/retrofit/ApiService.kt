package com.example.data.retrofit

import com.example.domain.models.DetailsModel
import com.example.domain.models.FlashSaleListModel
import com.example.domain.models.LatestListModel
import com.example.domain.models.WordsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest() : Response<LatestListModel>

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale() : Response<FlashSaleListModel>

    @GET("4c9cd822-9479-4509-803d-63197e5a9e19")
    suspend fun getWords() : Response<WordsModel>

    @GET("f7f99d04-4971-45d5-92e0-70333383c239")
    suspend fun getDetails() : Response<DetailsModel>
}