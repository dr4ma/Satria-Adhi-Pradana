package com.example.data.retrofit

import android.util.Log
import com.example.data.utills.FLASH_SALE_REQUEST_TAG
import com.example.domain.models.DetailsModel
import com.example.domain.repository.DetailsRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class DetailsRequest : DetailsRepository {

    override suspend fun getDetails(): Flow<DetailsModel> = callbackFlow{
        val requests = RetrofitInstance.apiService.getDetails()
        if(requests.isSuccessful){
            launch {
                val detailsModel = requests.body()
                if(detailsModel != null){
                    send(detailsModel)
                }
            }
        }
        else{
            Log.e(FLASH_SALE_REQUEST_TAG, requests.code().toString())
        }
        awaitClose()
    }.distinctUntilChanged()
}