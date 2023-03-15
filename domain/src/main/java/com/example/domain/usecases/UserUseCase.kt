package com.example.domain.usecases

import com.example.domain.models.UserModel
import com.example.domain.models.realmModels.UserModelRealm
import com.example.domain.repository.UserRepository
import com.example.domain.utills.RealmState
import com.example.domain.utills.mapToRealmModel
import com.example.domain.utills.mapToRegularModel
import javax.inject.Inject

class UserUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun insertOrUpdateUserModel(model: UserModel, function: (RealmState) -> Unit){
        userRepository.insertOrUpdateUserModel(model.mapToRealmModel()){
            function(it)
        }
    }

    fun getUserModel(function:(UserModel) -> Unit){
        userRepository.getUserModel {
            function(it.mapToRegularModel())
        }
    }
}