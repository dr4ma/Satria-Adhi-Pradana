package com.example.satriaadhipradana.presentation.fragments.details

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.DetailsModel
import com.example.domain.usecases.DetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsUseCase: DetailsUseCase): ViewModel() {

    private val _details: MutableLiveData<DetailsModel> = MutableLiveData()
    val details = _details

    fun getDetails(){
        viewModelScope.launch(Dispatchers.IO) {
            detailsUseCase.getDetails().collect{ details ->
                _details.postValue(details)
            }
        }
    }
}