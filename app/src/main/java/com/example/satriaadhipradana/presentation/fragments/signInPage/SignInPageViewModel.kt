package com.example.satriaadhipradana.presentation.fragments.signInPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UserModel
import com.example.domain.usecases.UserUseCase
import com.example.domain.utills.RealmState
import com.example.satriaadhipradana.utills.isEmailValid
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInPageViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    private val _userModel: MutableLiveData<UserModel> = MutableLiveData()
    val userModel = _userModel

    fun getUserModel() {
        userUseCase.getUserModel {
            _userModel.postValue(it)
        }
    }

    fun insertOrUpdateUserModel(firstName: String, lastName: String, email: String, onSuccess: () -> Unit, onError:() -> Unit) {
        userUseCase.insertOrUpdateUserModel(UserModel(id = 0, firstName = firstName, lastName = lastName, email = email), {
            onSuccess()
        }, {
            onError()
        })
    }
}