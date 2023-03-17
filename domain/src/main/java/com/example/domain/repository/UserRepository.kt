package com.example.domain.repository

import com.example.domain.models.realmModels.UserModelRealm
import com.example.domain.utills.RealmState

interface UserRepository {

    fun insertOrUpdateUserModel(model : UserModelRealm, onSuccess:() -> Unit, onError:() -> Unit)

    fun getUserModel(function:(UserModelRealm) -> Unit)
}