package com.example.domain.repository

import com.example.domain.models.realmModels.UserModelRealm
import com.example.domain.utills.RealmState

interface UserRepository {

    fun insertOrUpdateUserModel(model : UserModelRealm, function:(state : RealmState) -> Unit)

    fun getUserModel(function:(UserModelRealm) -> Unit)
}