package com.example.domain.usecases

import com.example.domain.models.FlashSaleModel
import com.example.domain.models.LatestModel
import com.example.domain.repository.Page1Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Page1UseCase @Inject constructor(private val page1Repository: Page1Repository) {

    suspend fun getLatest(): Flow<MutableList<LatestModel>> = flow {
        page1Repository.getLatest().collect{
            emit(it.latest)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()

    suspend fun getFlashSale(): Flow<MutableList<FlashSaleModel>> = flow {
        page1Repository.getFlashSale().collect{
            emit(it.flash_sale)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()

    suspend fun getWords(): Flow<MutableList<String>> = flow {
        page1Repository.getWords().collect{
            emit(it.words)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()
}