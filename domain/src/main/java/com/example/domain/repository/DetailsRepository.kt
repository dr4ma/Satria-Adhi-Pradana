package com.example.domain.repository

import com.example.domain.models.DetailsModel
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {

    suspend fun getDetails() : Flow<DetailsModel>
}