package com.example.data.retrofit

import android.util.Log
import com.example.data.utills.FLASH_SALE_REQUEST_TAG
import com.example.data.utills.LATEST_REQUEST_TAG
import com.example.data.utills.WORDS_REQUEST_TAG
import com.example.domain.models.FlashSaleListModel
import com.example.domain.models.LatestListModel
import com.example.domain.models.WordsModel
import com.example.domain.repository.Page1Repository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class Page1Requests : Page1Repository {

    override suspend fun getLatest(): Flow<LatestListModel> = callbackFlow{
        val requests = RetrofitInstance.apiService.getLatest()
        if(requests.isSuccessful){
            launch {
                val listModel = requests.body()
                if(listModel != null){
                    send(listModel)
                }
            }
        }
        else{
            Log.e(LATEST_REQUEST_TAG, requests.code().toString())
        }
        awaitClose()
    }.distinctUntilChanged()

    override suspend fun getFlashSale(): Flow<FlashSaleListModel> = callbackFlow {
        val requests = RetrofitInstance.apiService.getFlashSale()
        if(requests.isSuccessful){
            launch {
                val listModel = requests.body()
                if(listModel != null){
                    send(listModel)
                }
            }
        }
        else{
            Log.e(FLASH_SALE_REQUEST_TAG, requests.code().toString())
        }
        awaitClose()
    }.distinctUntilChanged()

    override suspend fun getWords(): Flow<WordsModel> = callbackFlow{
        val requests = RetrofitInstance.apiService.getWords()
        if(requests.isSuccessful){
            launch {
                val listModel = requests.body()
                if(listModel != null){
                    send(listModel)
                }
            }
        }
        else{
            Log.e(WORDS_REQUEST_TAG, requests.code().toString())
        }
        awaitClose()
    }
}