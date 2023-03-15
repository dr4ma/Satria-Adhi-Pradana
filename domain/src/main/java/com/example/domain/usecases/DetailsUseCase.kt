package com.example.domain.usecases

import com.example.domain.models.DetailsModel
import com.example.domain.repository.DetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DetailsUseCase @Inject constructor(private val detailsRepository: DetailsRepository) {

    suspend fun getDetails() : Flow<DetailsModel> = flow {
        detailsRepository.getDetails().collect{
            emit(it)
        }
    }.flowOn(Dispatchers.IO).distinctUntilChanged()
}