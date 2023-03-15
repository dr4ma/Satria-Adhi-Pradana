package com.example.satriaadhipradana.presentation.fragments.page1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.FlashSaleModel
import com.example.domain.models.LatestModel
import com.example.domain.usecases.Page1UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Page1ViewModel @Inject constructor(private val page1UseCase: Page1UseCase) : ViewModel() {

    private var job: Job? = null
    private val _latestList: MutableLiveData<MutableList<LatestModel>> = MutableLiveData()
    val latestList = _latestList

    private val _flashSale: MutableLiveData<MutableList<FlashSaleModel>> = MutableLiveData()
    val flashSale = _flashSale

    private val _words: MutableLiveData<MutableList<String>> = MutableLiveData()
    val words = _words

    fun getPage1Info() {
        getLatest() { latest ->
            getFlashSale() { flashSale ->
                _latestList.value = latest
                _flashSale.value = flashSale
            }
        }
    }

    private fun getLatest(onSuccess: (MutableList<LatestModel>) -> Unit) {
        viewModelScope.launch {
            page1UseCase.getLatest().collect { latestList ->
                if (latestList.isNotEmpty() && latestList != _latestList.value) {
                    onSuccess(latestList)
                }
            }
        }
    }

    private fun getFlashSale(onSuccess: (MutableList<FlashSaleModel>) -> Unit) {
        viewModelScope.launch {
            page1UseCase.getFlashSale().collect { flashSaleList ->
                if (flashSaleList.isNotEmpty() && flashSaleList != _latestList.value) {
                    onSuccess(flashSaleList)
                }
            }
        }
    }

    fun getWords(searchText: String) {
        job?.cancel()
        job = viewModelScope.launch {
            delay(1000)
            page1UseCase.getWords().collect { words ->
                _words.postValue(words.filter { it.startsWith(searchText, ignoreCase = true) } as MutableList<String>?)
            }
        }
    }
}