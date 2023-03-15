package com.example.domain.repository

import com.example.domain.models.FlashSaleListModel
import com.example.domain.models.LatestListModel
import com.example.domain.models.WordsModel
import kotlinx.coroutines.flow.Flow

interface Page1Repository {

    suspend fun getLatest() : Flow<LatestListModel>

    suspend fun getFlashSale() : Flow<FlashSaleListModel>

    suspend fun getWords() : Flow<WordsModel>
}